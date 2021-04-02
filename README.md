# Mobile_Programming


## Task

Laboratory work No.3 at Mobile Application Programming consist in implementing API layer of your app.
Implementation of API layer in your app represents integration of your app with some specific REST API or TCP server, fetching of real data and populating of UI with data received from network.

Laboratory work task:

* Pick an API it could be public or private in case you have access to it. You could use your own API or TCP server (in case you a building chat). In case if you use Firebase or another serverless service, please add integration to Firebase but also implement connection to another API by performing standard HTTP requests.
* Implement at least 2 GET and 2 POST requests. At least 1 of your request should send data to API by request body in JSON format, but not by URL queries.
* On Android you have to use Retrofit(https://square.github.io/retrofit/) and kotlin coroutines on iOS you have to use Alamofire(https://github.com/Alamofire/Alamofire) and RxSwift(https://github.com/ReactiveX/RxSwift) 
* Add 2 more screens with implemented design, your app should have at least 5 screen, not just layout, but with implemented design.
* Add basic navigation component for in app navigation drawer menu(swipeable menu from left to right), or tab bar navigation(bottom bar with tabs) 
    
## Demo
![Alt Text](https://github.com/dgaponcic/Mobile_Programming/blob/lab3/demo.gif)

## Implementation

The application has a lot of images and allow the user to save to notes the images he/she liked.
* used unsplash api to get images
* As I've read here (https://amp.reddit.com/r/androiddev/comments/2owzo3/since_apps_can_be_decompiled_how_handle_secret/) I wanted to store private info on the server, so I've build my own api, and used it as a proxy for unsplash.
* My api has the following routes:

POST /auth to get JWT token

GET  /images to get images(requires auth)

GET /image/:id to get image by id(requires auth)

POST /note to create a new note(requires auth)

GET /notes to get the notes of an user(requires auth)
