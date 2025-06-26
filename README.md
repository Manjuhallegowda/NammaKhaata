# NammaKhaata - Personal Expense Tracker

NammaKhaata is an Android application that helps users track their expenses through SMS parsing and manual entry. The app provides a simple, user-friendly interface for managing personal finances.

## Prerequisites

1. Android Studio (Latest version - Arctic Fox or newer)
2. JDK 17 or newer
3. Android SDK:
   - Minimum SDK: 23 (Android 6.0)
   - Target SDK: 33 (Android 13)
4. Firebase Account and Setup:
   - Create a project in Firebase Console
   - Add your Android app to Firebase project
   - Download `google-services.json` and place it in the `app` directory

## Dependencies

The project uses the following major dependencies:

```gradle
// Kotlin and Android
- Kotlin: 1.8.10
- Android Gradle Plugin: 8.0.2
- Compose: 1.4.3
- Material3: 1.1.0

// Firebase
- Firebase BOM: 32.1.0
- Firebase Authentication

// Room Database
- Room: 2.5.2

// Charts
- MPAndroidChart: v3.1.0

// Coroutines
- Kotlinx Coroutines: 1.7.1
```

## Setup Instructions

1. Clone the repository:
```bash
git clone https://github.com/Manjuhallegowda/NammaKhaata.git
```

2. Open Android Studio and select "Open an existing Android Studio project"

3. Navigate to the cloned directory and click "OK"

4. Firebase Setup:
   - Go to Firebase Console (https://console.firebase.google.com/)
   - Create a new project or use existing one
   - Add Android app with package name: `com.nammakhaata.app`
   - Download `google-services.json`
   - Place `google-services.json` in the `app` directory

5. Sync Project with Gradle Files:
   - Click "Sync Project with Gradle Files" in Android Studio
   - Wait for the sync to complete

6. Run the app:
   - Connect an Android device or use an emulator
   - Click "Run" in Android Studio

## Required Permissions

The app requires the following permissions (already added in AndroidManifest.xml):
- `READ_SMS`: For reading SMS messages
- `RECEIVE_SMS`: For receiving SMS notifications
- `INTERNET`: For Firebase Authentication

You'll need to grant these permissions at runtime when the app first launches.

## Features

- Phone number-based registration with Firebase Authentication
- SMS parsing for automatic transaction tracking
- Manual transaction entry
- Categorize transactions (Food, Travel, Bills, Shopping, etc.)
- Daily, weekly, and monthly spend tracking
- Analytics dashboard with charts
- Light/Dark mode support
- Export transactions to CSV

## Contributing

Feel free to submit issues and enhancement requests.

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Troubleshooting

1. If you get Gradle sync issues:
   - Make sure you have the latest Android Studio
   - Update Android Studio and Android SDK tools
   - Invalidate caches and restart Android Studio

2. If Firebase Authentication doesn't work:
   - Verify `google-services.json` is properly placed
   - Enable Phone Authentication in Firebase Console
   - Add test phone numbers in Firebase Console for development

3. For SMS permission issues:
   - Make sure to request runtime permissions
   - For Android 10+ devices, grant SMS permissions manually in Settings
