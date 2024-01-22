# NITCONF - MODULE 2
NITCONF is a conference website designed to facilitate paper submissions for evaluation. The platform enables reviewers to assess papers assigned to them by the Program Committee. The repository encompasses the entire Reviewers Project for this conference.



Table of Contents
=================
  * [Introduction](#1-introduction)
    * 1.1 [Purpose](#11-purpose)
    * 1.2 [Document Conventions](#12-document-conventions)
    * 1.3 [Intended Audience and Reading Suggestions](#13-intended-audience-and-reading-suggestions)
    * 1.4 [Product Scope](#14-product-scope)
    * 1.5 [References](#15-references)
  * [Overall Description](#overall-description)
    * 2.1 [Product Overview](#21-product-overview)
    * 2.2 [User Classes and Characteristics](#23-user-classes-and-characteristics)
    * 2.3 [Operating Environment](#24-operating-environment)
    * 2.4 [Design and Implementation Constraints](#25-design-and-implementation-constraints)
    * 2.5 [User Documentation](#26-user-documentation)
    * 2.6 [Assumptions and Dependencies](#27-assumptions-and-dependencies)
  * [External Interface Requirements](#external-interface-requirements)
    * 3.1 [User Interfaces](#31-user-interfaces)
    * 3.2 [Hardware Interfaces](#32-hardware-interfaces)
    * 3.3 [Software Interfaces](#33-software-interfaces)
    
  <!-- * [System Features](#system-features)
    * 4.1 [System Feature 1](#41-system-feature-1)
    * 4.2 [System Feature 2 (and so on)](#42-system-feature-2-and-so-on)
  * [Other Nonfunctional Requirements](#other-nonfunctional-requirements)
    * 5.1 [Performance Requirements](#51-performance-requirements)
    * 5.2 [Safety Requirements](#52-safety-requirements)
    * 5.3 [Security Requirements](#53-security-requirements)
    * 5.4 [Software Quality Attributes](#54-software-quality-attributes)
    * 5.5 [Business Rules](#55-business-rules)
  * [Other Requirements](#other-requirements)
* [Appendix A: Glossary](#appendix-a-glossary)
* [Appendix B: Analysis Models](#appendix-b-analysis-models)
* [Appendix C: To Be Determined List](#appendix-c-to-be-determined-list)

 -->

<!-- 
## Revision History
| Name | Date    | Reason For Changes  | Version   |
| ---- | ------- | ------------------- | --------- |
|      |         |                     |           |
|      |         |                     |           |
|      |         |                     |           | -->

## 1. Introduction
### 1.1 Purpose 
The Re­viewers section in the­ NITCONF explains what reviewe­rs can do. It gives rules and steps for re­viewers to easily and smoothly judge­ and rate papers that people­ send in.

### 1.2 Document Conventions
This document follows IEEE formatting requirements.

### 1.3 Intended Audience and Reading Suggestions
The document is intended to serve several groups of audience members :
* System Designer:
    * They are the primary audience. It provides crucial information guiding the design phase.
* Program Committee:
    * They are expected us to provide the required resources mentioned in the SRS Document.
* Author:
    * They are expected to upload the Document/ Thesis in the specified format.
* Tester:
    * They will refer to the SRS to ensure that the actual implementation aligns seamlessly with the specified requirements.

### 1.4 Product Scope
* User Authentication:
    * A secure login page for reviewers to access the system.
* Reviewer Dashboard:
    * Upon logging in, reviewers are directed to a personalized homepage, presenting a comprehensive overview of papers assigned to them.
* Paper Presentation:
    * The system organizes assigned papers in a clear and systematic row-wise fashion for easy navigation.
* Reviewing Functionality:
    * Reviewers have the capability to thoroughly evaluate papers, with options to edit and submit reviews seamlessly.
These features collectively form the product scope, ensuring an efficient and user-friendly platform for the review process.

### 1.5 References 
Refer to the following links for additional resources:
* https://www.springer.com/gp/computer-science/lncs/online-conference-service
* https://support.springer.com/en/support/solutions/articles/6000245514-description-of-the-end-to-end-process-in-equinocs

## Overall Description
### 2.1 Product Overview
The reviewers page in NITCONF will serve as an interface for the reviewers to mark their review, add comments, feedbacks and ratings to the papers assigned to them by the Programme Committee. The Reveiwers would be provided with a login page where they can login with their credentials. There will be 3 sections under it
1. To Review  - All the papers that has to be reviewed and submitted to PC would be displayed here along with the deadline. After submission, these papers will go to the Reviewed session.
2. Reviewed - The papers submitted to PC would be displayed along with the deadlines. The reviewer has the option to edit it and resubmit before the deadline. After deadline these papers will go to history.
3. History - The history tab will show all the papers reviewed by that reviewer so far with the status and date.
4. Notifications - All notifications from the PC would be here.



![diag1](https://github.com/afrasd/NITCONF/assets/103187343/e5eede35-4fd2-43b8-9ed8-cf68f1771bb0)




### 2.2 User Classes and Characteristics
**User - Reviewer**
- **Frequency of use**: Reviewers engage with the system intensively during the conference periods.
- **Functions used**: 
	- **paper review**: reviewers will be able to give the review based on some metrics such as originality, relevance, quality, readability, technical soundness etc, additionally they would be able to give a confidence rating. finally they can accept/reject the paper or click on another option called revise. After finalizing the changes they can submit the review to the PC. 
	- **Commenting and Feedback**: They provide detailed comments and feedback for each paper, which may include critiques, suggestions for improvement, and overall assessments.
- **Technical Expertise**: A simple understanding of basic computer based tasks is enough to navigate the system as it is user friendly.
- ** Security Levels**: Reviewers require secure login credentials to login in to the system, this is done to ensure the integrity and confidentiality of the reviewing process.
- **Educational Level and Experience**: They possess significant expertise in their respective academic or industry fields. They must also have experience in the reviewing process which would enable them to critique better and provide some insightful comments.

**Pertinent Requirements**
- easy access to assigned papers because of the user friendly UI.
	- divided into two sections : to review and review
- deadline tracking and submission status.
	- a visible and clear display of the deadline for each paper to support timely reviews and submission along with reminders and notifications.
	- real time status updation once the reviewer has submitted his review.
- decline to review.
 	- this option would be provided to the reviewer if they wish to decline to give a review.
- edit and resubmit capabilities available for reviewers.
- confidentiality and anonymity between reviewers and the authors of the paper by enforcing a double blind situation.

### 2.3 Operating Environment
**General requirements**: NITCONF designed to be lightweight and accessible on platforms such as desktop computers and laptops.
-**Performance Specification**: for optimal performance any modern processor, at least 8gb of ram and a stable internet connection re recommended for laptop and desktop users.
-**Cross platform compatibility** irrespective of the OS , this application (NITCONF) can run smoothly.

**Server Requirements**
-Platform: Java-compatible server environment, as Spring Framework is Java-based.
-Web Server: Compatible with servers like Apache Tomcat, Jetty, or similar servlet containers.
-Java Version: Requires Java JDK 8 or higher, considering Spring Framework's requirements.
-Memory and Storage: Sufficient RAM and disk space for handling concurrent user sessions and data storage. The exact requirements depend on the expected user load and data volume.

**Client-Side Requirements**
-Web Browsers: Compatible with modern web browsers including Google Chrome, Mozilla Firefox, Microsoft Edge, and Safari. The application should be tested across these browsers for consistency.
-JavaScript Enabled: As modern web applications often rely on JavaScript for dynamic content, users should have JavaScript enabled in their browsers.

**Network Requirements**
-Bandwidth and Connectivity: Adequate network speed and stability for seamless access and data exchange, especially important for data-intensive operations or real-time features.
-Security Protocols: Utilizes HTTPS for secure communication over the internet.

**Software Dependencies**
-Spring Framework
-Database: Compatible with relational databases like MySQL, MySQL workbench, PostgreSQL, or similar, depending on the application's data persistence requirements.
-Frontend Technologies: Includes HTML5, CSS3, JavaScript.

**Deployment Environment**
Containerization: The application is containerized using Docker, Kubernetes.
API testing tools: Postman, swagger.io, SoapUI.
CI/CD Pipelines: Integration with continuous integration and continuous deployment tools.


### 2.4 Design and Implementation Constraints
- **Security Concerns**: Risks of unauthorized access and data breaches.
- **User Authentication and Authorization**: Potential issues in login processes and user permission management.
- **User Experience (UX)**:Possible usability issues impacting user satisfaction.
- **Data Integrity and Validation**:Risks of data corruption or acceptance of invalid data.
- **Scalability**:Potential performance degradation with increased usage.
- **File Uploads**:Security vulnerabilities and risks associated with file uploads.
- **Review Workflow**: Inefficiencies or confusion in the paper review process.
- **Backup and Recovery**: Potential data loss without regular backups and recovery plan.

### 2.5 User Documentation
#### Login and Dashboard Navigation
- **Login**: Reviewers log in with their credentials and are directed to the reviewer dashboard.
- **Profile**: The user's profile icon is displayed in the top right corner, linking to the profile page.
- **homepage**: contains links/buttons to the following options:
  - **To Review**: A list of papers assigned for review.
  - **Reviewed**: Papers that have been reviewed by the user.
  - **View History**: A history of papers reviewed in the past 6 months.

## Pages and Functionalities
### 'To Review' Page
- **Layout**: Displays assigned papers in a row-wise manner.
- **Columns**:
  1. **Pdf id and Downloads**: Includes a pdf id, 'Abstract' and 'PDF Download' buttons.
  2. **Paper Title and Actions**: Shows the paper's title with 'Review' and 'Display All Reviews' options. 'Review' opens a pop-up for rating, commenting, and final actions ('Accept', 'Reject', or 'Revise'). 'Display All Reviews' reveals all previous comments/reviews.
  3. **Status**: Indicates the current status of the paper (Accept/Reject/Pending).
  4. **Revision**: Shows the revision round of the paper (e.g., first, second).
  5. **Deadline**: Lists the review deadline set by the Program Committee.
  6. **Decline**: A button that can be pressed if the reviewer chooses not to review that paper.
     
 
     ![1](https://github.com/afrasd/NITCONF/assets/103187343/4a1f5693-12b0-46d3-b598-0eaae21ff74e)


### 'Reviewed' Page
- **Content**: Lists all reviewed papers.
- **Columns**:
  1. **Pdf id and Downloads**: Includes a pdf id, 'Abstract' and 'PDF Download' buttons.
  2. **Paper Title and Edit Options**: Displays the paper's title with 'Edit' and 'Display All Reviews' buttons. 'Edit' allows modification of the most recent review. 'Display All' shows all past reviews.
  3. **Status**: The final status of the paper (Accept/Reject).
  4. **Revision**: Shows the revision round of the paper (e.g., first, second).
  5. **Deadline**: The review deadline, after which the paper is removed from this page.
 ![2](https://github.com/afrasd/NITCONF/assets/103187343/3c86a087-d8ae-4a67-85b0-adbc787777c6)

  
  
### 'View History' Page
- **Content**: Lists all reviewed papers in the last 6 months.
- **Columns**:
  1. **Pdf id and Downloads**: Includes a paper pdf id, 'Abstract' and 'PDF Download' buttons.
  2. **Paper Title and Edit Options**: Displays the paper's title with a 'Display All Reviews' button.
  3. **Status**: The final status of the paper (Accept/Reject).
  4. **Revision**: Shows the revision round of the paper (e.g., first, second).
  5. **Deadline**: The review deadline, after which the paper is removed from this page.

     
 ![3](https://github.com/afrasd/NITCONF/assets/103187343/6a0ac50c-11a8-41f3-9a9b-7fae0e3a2c41)

     

### 'Notifications' Page
- **Content**: Lists all notifications from PC, like paper assignments and deadline reminders.
  
  
### 2.6 Assumptions and Dependencies
## Assumptions:
- **Third-Party Components**: Assuming the availability and reliability of third-party libraries or frameworks used in the development of the website.
- **Internet Connectivity**: Assuming that users and reviewers have consistent internet access for seamless interaction with the platform.
- **Browser Compatibility**: Assuming standard browser compatibility for optimal user experience.
- **User Cooperation**: Assuming users will follow proper guidelines for paper submissions and reviews.
- **Work Flow**: Assigned by the program committee, reviewers submit their evaluations, and the committee provides the final response to authors. All communication between reviewers and authors is facilitated through the program committee for efficiency and coherence.

## Dependencies:
- **External APIs**:Dependency on external APIs for features like user authentication or data retrieval.
- **Database System**:Dependency on the chosen database system for storing and retrieving paper and user data.
- **Hosting Service**:Dependency on a reliable hosting service for the website to be accessible online.
- **Development Tools**:Dependency on specific development tools, languages, or frameworks.

## External Interface Requirements
### 3.1 User Interfaces
Our platform's user interface has been meticulously crafted to provide a user-friendly and efficient experience for reviewers. Upon logging in, reviewers will be greeted with a clean and intuitive dashboard that offers quick access to their assigned submissions. The interface incorporates clear navigation menus, allowing reviewers to seamlessly move between different sections of the platform.

Within each submission, the user interface allows reviewers to access abstracts, full papers, and supplementary materials with ease. A centralized hub for reviewing activities, including providing feedback, assigning scores.
### 3.2 Hardware Interfaces
- Desktop/Laptop:

  - Processor: A dual-core processor or equivalent for smooth processing.

  - RAM: 4 GB or higher to handle multiple tasks concurrently.

  - Display: A screen resolution of 1280x800 or higher for an optimal viewing experience.
### 3.3 Software Interfaces
1. Integration with External Software Components:

- a. Database Management System:

  - Name and Version: MYSQL 8.0
  

- b. Operating System:

  - Name and Version: Ubuntu / MacOS / Windows

- c. Frontend Framework:

  - Name and Version: HTML, CSS, JS

2. Data Flow and Messages:

 - a. Incoming Data:

     -  Submission Data: Handled by Spring MVC controllers, data from submitted papers will be processed and stored in the MYSQL database.

- b. Outgoing Data:

   - Review Feedback: Managed by Spring MVC controllers, sending review feedback stored in MYSQL to the frontend.

<!-- ## System Features
This template illustrates organizing the functional requirements for the product by system features, the major services provided by the product. You may prefer to organize this section by use case, mode of operation, user class, object class, functional hierarchy, or combinations of these, whatever makes the most logical sense for your product.
### 4.1 System Feature 1
Don’t really say “System Feature 1.” State the feature name in just a few words.
4.1.1   Description and Priority
 Provide a short description of the feature and indicate whether it is of High, Medium, or Low priority. You could also include specific priority component ratings, such as benefit, penalty, cost, and risk (each rated on a relative scale from a low of 1 to a high of 9).
4.1.2   Stimulus/Response Sequences
 List the sequences of user actions and system responses that stimulate the behavior defined for this feature. These will correspond to the dialog elements associated with use cases.
4.1.3   Functional Requirements
 Itemize the detailed functional requirements associated with this feature. These are the software capabilities that must be present in order for the user to carry out the services provided by the feature, or to execute the use case. Include how the product should respond to anticipated error conditions or invalid inputs. Requirements should be concise, complete, unambiguous, verifiable, and necessary. Use “TBD” as a placeholder to indicate when necessary information is not yet available.
 
 Each requirement should be uniquely identified with a sequence number or a meaningful tag of some kind.

### 4.2 System Feature 2 (and so on)






## Other Nonfunctional Requirements

### 5.1 Performance Requirements
System is designed to help reviewers review papers assigned to them. It involves the dynamic process of paper-review management with efficiency and precision. Some important functionalities of the reviewer include accepting/rejecting/editing/deleting/declining/accept upon further revision.
   #### Response time and efficiency
   system will respond in less than a second of submitting the request. Tasks like viewing his/her/their reviewed papers history might take some extra seconds but the overall performance will be fast and efficient.
   Can use a mix of Server side rendering for the intial load of the page for better SEO (search engine optimization) and then Client side rendering for dynamic interactions.


### 5.2 Safety Requirements
The system will store all the data in a secure database. The reviewers will be able to view information but will not have the privilege to modify/edit it if the PC chair has already processed it. This privilege will be given to the PC committee and only they have the right to update the database. These are the two different types of accessors and have varying access constraints.
In terms of the safety aspect, the system does not pose a threat to its users. To combat attacks by malware, backing up the database is advised.

### 5.3 Security Requirements
Specify any requirements regarding security or privacy issues surrounding use of the product or protection of the data used or created by the product. Define any user identity authentication requirements. Refer to any external policies or regulations containing security issues that affect the product. Define any security or privacy certifications that must be satisfied.
### 5.4 Software Quality Attributes
Specify any additional quality characteristics for the product that will be important to either the customers or the developers. Some to consider are: adaptability, availability, correctness, flexibility, interoperability, maintainability, portability, reliability, reusability, robustness, testability, and usability. Write these to be specific, quantitative, and verifiable when possible. At the least, clarify the relative preferences for various attributes, such as ease of use over ease of learning.
### 5.5 Business Rules
List any operating principles about the product, such as which individuals or roles can perform which functions under specific circumstances. These are not functional requirements in themselves, but they may imply certain functional requirements to enforce the rules.

## Other Requirements
Define any other requirements not covered elsewhere in the SRS. This might include database requirements, internationalization requirements, legal requirements, reuse objectives for the project, and so on. Add any new sections that are pertinent to the project.
### Appendix A: Glossary
Define all the terms necessary to properly interpret the SRS, including acronyms and abbreviations. You may wish to build a separate glossary that spans multiple projects or the entire organization, and just include terms specific to a single project in each SRS.
### Appendix B: Analysis Models
Optionally, include any pertinent analysis models, such as data flow diagrams, class diagrams, state-transition diagrams, or entity-relationship diagrams.
### Appendix C: To Be Determined List
Collect a numbered list of the TBD (to be determined) references that remain in the SRS so they can be tracked to closure. -->
