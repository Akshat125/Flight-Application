[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]

<br />
<img src="src/client/src/Images/flightLogo.jpeg" alt="Logo">

## About The Project
This system is implemented using the traditional client server layered architecture based on the REST protocol, while leveraging various features of modern web applications. The server side is built on the Spring Boot framework for Java, which allows the handling of simple API calls and persistent storage through an inbuilt database feature. The client side is composed of HTML/CSS/JavaScript to be run in a browser, with the aid of React.js library.

### Use-case model:
<img src="modles/UseCaseDiagram.png">

### UML model: 
<img src="modles/UMLClassDiagram.png">

### Communication diagram:
<img src="modles/CommunicationDiagram.png">

### Component diagram: 
<img src="modles/ComponentDiagram.png">

### Built With

* [![React][React.js]][React-url]
* [![Bootstrap][Bootstrap.com]][Bootstrap-url]

<!-- GETTING STARTED -->
## Getting Started

### Prerequisites for starting up the system
* Linux:
  1. ```sh
     $ sudo apt install nodejs npm
     ```
  2. navigate to "Flight-Application"
  3. ```sh
     $ ./start_project.sh
     ```
* MacOs:
  1. ```sh
     $ brew install node
     ```
  2. navigate to "Flight-Application"
  3. ```sh
     $ ./start_project.sh
     ```
* Windows:
  1. download Node.js installer and install npm from browser
  2. navigate to "Flight-Application"
  3. ```sh
     $ ./start_project.bat
     ```

### Starting server
1. navigate to "Flight-Application"
2. ```shell
     $ ./gradlew clean build
     $ ./gradlew bootRun;
     ```

### Starting client
  1. navigate to "Flight-Application/src/client"
  2. ```sh
     $ npm install --force --silent
     $ npm start --silent; 
     ```
     
## Usage
<img src="UI_Images/img.png">
<img src="UI_Images/img_2.png">
<img src="UI_Images/img_3.png">
<img src="UI_Images/img_4.png">
<img src="UI_Images/img_1.png">
<img src="UI_Images/img_5.png">

## Contributing
Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

Distributed under the MIT License. See `LICENSE.md` for more information.


<!-- LINKS & IMAGES -->
[contributors-shield]: https://img.shields.io/github/contributors/github_username/repo_name.svg?style=for-the-badge
[contributors-url]: https://github.com/github_username/repo_name/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/github_username/repo_name.svg?style=for-the-badge
[forks-url]: https://github.com/github_username/repo_name/network/members
[stars-shield]: https://img.shields.io/github/stars/github_username/repo_name.svg?style=for-the-badge
[stars-url]: https://github.com/github_username/repo_name/stargazers
[issues-shield]: https://img.shields.io/github/issues/github_username/repo_name.svg?style=for-the-badge
[issues-url]: https://github.com/github_username/repo_name/issues
[license-shield]: https://img.shields.io/apm/l/vim-mode
[license-url]: https://github.com/Akshat125/Flight-System-Application/blob/main/LICENSE.md
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/linkedin_username
[React.js]: https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB
[React-url]: https://reactjs.org/
[Bootstrap.com]: https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white
[Bootstrap-url]: https://getbootstrap.com

