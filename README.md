##SRT Android developer challenge

* Description

- Using the best API available on this side of the
  universe https://developer.marvel.com/ make a simple master detail app that allows
  the user to scroll through all the comics ever released and view details for each
  comic.
  You will need to sign up for a free developer account with Marvel.

* Functional requirements
  • When we open the application we would like to see a list of all Marvel’s
  released comic books
  • When tapping on a comic it should open up a modal view showing the cover
  art full screen
  Feel free to use whatever flare you can to show off your skills.
  Don't spend more than a few hours working on this. Don't worry if you don't get
  the task finished as we'd like to hear how you prioritised your time.
* Design

- Technical requirements
  • Application needs to run on Android Studio device emulation.
  • You are free to use whatever frameworks or tools you see fit

* Evaluation Criteria
  • Adaptability. We want to see how well you can develop for the different
  screen sizes.
  • You create maintainable code
  • You create testable code
  • You care about the user experience
  • You pay attention to detail
  • You develop in a scalable manner
* Deliverables
  • Zipped package of the project

-----------------------------

* Project Explanation:

- The project uses the following resources to make an API call:

1. Account created for credentials: https://developer.marvel.com/account
2. Authentication explanation for the API
   signing: https://developer.marvel.com/documentation/authorization
3. API interactive tester used: https://developer.marvel.com/docs with GET /v1/public/comics
   documentation.
4. MD5 hash generator: https://www.w3docs.com/tools/string-md5-generator

- Initially the app shows a list of comic results, we can observe a title of the comic and main
  image.
- When we click on each image, we should see the image propagated to the next screen using jetpack
  compose navigation.
- The app is using a clean code architecture divided in folders, so this makes the code easy to
  read, maintain, test and scalable.
- The repository is responsible to make an API call using suspendable functions with Flow.
- The VM pattern will keep the repository response and update the State holder of the UI.
- I used Jetpack compose for easiness and quick building a new UI using kotlin.
- Coroutines, for fetching async suspendable operations with Flow.
- DI with Hilt for reusing mock services like APIs or repositories and make it easy to test.
- I used retrofit, as type safe HTTP client for Android.
- I created one unit test, but due to time constraints, I only made one in the
  repository,
  but we could add more cases and test more scalable layers like the VM.
- With more time, I'd create more unit tests and instrumentation tests.