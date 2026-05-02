#!/usr/bin/env bash
set -euo pipefail

PUBSPEC="pubspec.yaml"

if [[ ! -f "$PUBSPEC" ]]; then
  echo "Fehler: $PUBSPEC nicht gefunden."
  exit 1
fi

current_line=$(grep -E '^version:' "$PUBSPEC" | head -n1 || true)
if [[ -z "$current_line" ]]; then
  echo "Fehler: Keine 'version:' Zeile in $PUBSPEC gefunden."
  exit 1
fi

current_version=${current_line#version: }
if [[ ! "$current_version" =~ ^([0-9]+)\.([0-9]+)\.([0-9]+)\+([0-9]+)$ ]]; then
  echo "Fehler: Unerwartetes Versionsformat: '$current_version'"
  echo "Erwartet: MAJOR.MINOR.PATCH+BUILD, z.B. 1.0.3+6"
  exit 1
fi

major=${BASH_REMATCH[1]}
minor=${BASH_REMATCH[2]}
patch=${BASH_REMATCH[3]}
build=${BASH_REMATCH[4]}

new_patch=$((patch + 1))
new_build=$((build + 1))
new_version="${major}.${minor}.${new_patch}+${new_build}"

sed -i -E "s/^version: .*/version: ${new_version}/" "$PUBSPEC"

echo "Version aktualisiert: ${current_version} -> ${new_version}"
