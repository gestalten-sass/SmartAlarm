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
