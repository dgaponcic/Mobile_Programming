# Mobile_Programming


## Task
Laboratory work No.4 at Mobile Application Programming consist in analyzing different presentation layer architectures (ex. MVC, MVP, MVVM and others) and selecting one for implementing it in your project.

Laboratory work task:

* Perform a research on several mobile app architectures, they are almost the same for both platforms. Most popular architecture are MVC, MVP, MVVM, RIBs https://github.com/uber/RIBs , VIPER mostly for iOS, Hexagonal architecture https://en.wikipedia.org/wiki/Hexagonal_architecture_(software) 
* Pick up an architecture which fits the best your project and refactor your code base to selected architecture. Your codebase should be refactored to follow idiomatic representation of selected architecture. You should follow principles of "Clean Architectures" https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html and "Clean code" https://www.investigatii.md/uploads/resurse/Clean_Code.pdf and please refactor your code to look clean and structured. Messy projects will not be evaluated.

Please pay attention: Architecture is not about physical structure of your project, location of files and folders. Architecture is about dependencies and decoupling between your classes (objects) and layers of your app.
    
## Demo
![Alt Text](https://github.com/dgaponcic/Mobile_Programming/blob/lab3/demo.gif)

## Implementation

The project is refactored using MVP architecture.

For example, structure of an FeedImage module:
* models
* FeedActivity
* FeedIO
* FeedPresenter

Used dependecy injection using Koin, as follows:
```
private val presenter: ImageOutput by inject { parametersOf(this) }
```
