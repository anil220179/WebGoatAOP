Author: Bojan Simic (bojansimic.com)

What is this project?

This is an instance of the OWASP WebGoat project. 
The project is an Eclipse ready implementation which means you can
fork this repo and import it directly into your Eclipse IDE.


The OWASP WebGoat (from owasp.org):

    WebGoat is a deliberately insecure J2EE web application maintained by 
    OWASP designed to teach web application security lessons. In each lesson, 
    users must demonstrate their understanding of a security issue by exploiting a
    real vulnerability in the WebGoat application. For example, in one of the 
    lessons the user must use SQL injection to steal fake credit card numbers. 
    The application is a realistic teaching environment, providing users with 
    hints and code to further explain the lesson.
    
    Why the name "WebGoat"? Developers should not feel bad about not knowing 
    security. Even the best programmers make security errors. What they need is 
    a scapegoat, right? Just blame it on the 'Goat! 

AspectJ & AOP:

    This version of the WebGoat project has several "aspects" that are created
    to mitigate some of the more common vulnerabilities in the web application. 
    
    These are located in the com.aspects project.
    
    To install AspectJ & AspectJ Development Toolkit, go to http://www.eclipse.org/ajdt/

Running locally:

    To run this locally, follow these steps (assuming you have Eclipse up and running):
    
    1. Download Tomcat 6 from http://tomcat.apache.org/download-60.cgi/
    2. Download the Eclipse Sysdeo plugin for tomcat and configure it. http://www.eclipsetotale.com/tomcatPlugin.html 
    3. Download AJDT from http://www.eclipse.org/ajdt/
    4. Fork this repo from github and check it out. 
    5. Import the project into eclipse using File > Import
    6. Configure the project to run on your Tomcat 6 install.
        Make sure you add -javaagent:<path to aspectj install>/aspectjweaver.jar 
        to the JVM parameters. 
        
        This can be done in Eclipse with Window > Preferences > Tomcat > 
        JVM Settings > Append JVM Parameters if you have the sysdeo plugin 
        installed from the previous step.
        
    7. Run tomcat and you should be all set. 
    
If you have questions, please contact me via github or bojansimic.com     
    

