# Release Guide

## Version Bump

Before creating a new Google Play release, run:

```bash
bash scripts/bump_release_version.sh
```

This updates `pubspec.yaml` from `MAJOR.MINOR.PATCH+BUILD` to:

- `MAJOR.MINOR.(PATCH+1)+(BUILD+1)`

Example:

- `1.0.4+7` -> `1.0.5+8`

## Build App Bundle

```bash
flutter build appbundle --release
```

Output file:

- `build/app/outputs/bundle/release/app-release.aab`

## Release Notes (Google Play Store)

Google Play Console verlangt für SmartAlarm Versionshinweise in genau 6 Sprachen:
`<de-DE>`, `<en-GB>`, `<es-ES>`, `<fr-FR>`, `<it-IT>`, `<nl-NL>`.

Release Notes bei jedem Update direkt in eine Textdatei (z. B. `release-notes.txt`) schreiben und via `xclip` in die Zwischenablage legen, um Einrückungsprobleme zu vermeiden:

```xml
<de-DE>
- Stichpunkt 1
- Stichpunkt 2
</de-DE>
<en-GB>
- Point 1
- Point 2
</en-GB>
<es-ES>
- Punto 1
- Punto 2
</es-ES>
<fr-FR>
- Point 1
- Point 2
</fr-FR>
<it-IT>
- Punto 1
- Punto 2
</it-IT>
<nl-NL>
- Punt 1
- Punt 2
</nl-NL>
```
