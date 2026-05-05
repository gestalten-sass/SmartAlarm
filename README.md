# Smart Alarm

Smart Alarm is a Flutter app for loud, fast manual alarm triggering on Android.

## Features

- One-tap alarm activation
- Multiple alarm sounds (including custom file)
- Optional vibration
- Optional keep-screen-awake behavior
- Multi-language UI

## Platform

- Android (primary)

## Tech Stack

- Flutter
- Dart
- Material 3 UI

## Local Development

```bash
flutter pub get
flutter run
```

## Build (Release)

```bash
flutter build appbundle --release
```

Generated bundle:

- `build/app/outputs/bundle/release/app-release.aab`

## Release

Release process notes are documented in [docs/RELEASE.md](docs/RELEASE.md).

## Repository Notes

- This repository contains source code only.
- Local signing files and secrets are intentionally excluded from version control.
