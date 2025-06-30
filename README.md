# Snap Chat Clone

A full-featured Snapchat clone built entirely with Kotlin for Android. This project replicates the core functionalities of Snapchat, including real-time messaging, image/video sharing, ephemeral stories, user authentication, and more. The app is designed with a modern, intuitive UI and follows best practices for scalable and maintainable Android development.

## Features

- **User Authentication**  
  Secure sign-up, login, and logout using Firebase Authentication.

- **Real-Time Chat**  
  Send and receive text, image, and video messages instantly.

- **Ephemeral Stories**  
  Share stories that disappear after 24 hours, similar to Snapchat.

- **Media Sharing**  
  Capture and share photos and videos using the device camera.

- **Friend Management**  
  Add, remove, and search for friends.

- **Push Notifications**  
  Receive notifications for new messages and story updates.

- **Profile Customization**  
  Update profile pictures, display names, and account settings.

- **Snap Map (Optional)**  
  View friends' locations on a map (configurable via privacy settings).

## Screenshots

<!-- Add screenshots of the app here, e.g.: -->
<!-- ![Login Screen](screenshots/login.png) -->
<!-- ![Chat Screen](screenshots/chat.png) -->

## Tech Stack

- **Language:** Kotlin
- **Framework:** Android SDK (Jetpack, Material Components)
- **Backend:** Firebase (Authentication, Firestore, Storage, Cloud Messaging)
- **Image Loading:** Glide or Coil
- **Push Notifications:** Firebase Cloud Messaging (FCM)

## Getting Started

### Prerequisites

- Android Studio (latest version recommended)
- Android device or emulator
- Firebase project (see below)

### Setup Instructions

1. **Clone the Repository**

   ```bash
   git clone https://github.com/Developer668/Snap-chat-clone.git
   cd Snap-chat-clone
   ```

2. **Open in Android Studio**

   - Open Android Studio.
   - Choose "Open an existing project" and select this folder.

3. **Configure Firebase**

   - Create a project on [Firebase Console](https://console.firebase.google.com/).
   - Add an Android app to your Firebase project.
   - Download the `google-services.json` file and place it in the `app/` directory.
   - Enable Firebase Authentication, Firestore Database, Storage, and Cloud Messaging.

4. **Build and Run**

   - Connect your Android device or start an emulator.
   - Click **Run** in Android Studio.

## Project Structure

```plaintext
app/
 ├── src/
 │    ├── main/
 │    │    ├── java/com/yourpackage/
 │    │    │    ├── auth/
 │    │    │    ├── chat/
 │    │    │    ├── story/
 │    │    │    ├── map/
 │    │    │    └── ...
 │    │    └── res/
 │    └── ...
 └── ...
```

- **auth/**: User authentication logic
- **chat/**: Real-time messaging components
- **story/**: Story creation and viewing
- **map/**: Snap Map features

## Contribution

Contributions are welcome! Please fork the repository, create a new branch for your feature or bugfix, and submit a pull request.

1. Fork the repo
2. Create your feature branch: `git checkout -b feature/YourFeature`
3. Commit your changes: `git commit -m 'Add new feature'`
4. Push to the branch: `git push origin feature/YourFeature`
5. Open a pull request

## License

This project is licensed under the MIT License.

## Disclaimer

This project is intended for educational purposes only. It is not affiliated with, endorsed by, or connected to Snap Inc. or Snapchat.
