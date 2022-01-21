# UserSignInSystem
This system is basing on Spring+Servlet+JSP+Hibernate+MySQL. It allows users to import personal information and store it into local database.

## How To Run

### Step 1
You can download from github as a .zip file, decompress it and open it with IDEA, but I recommend to clone git respository directly into IDEA.
git -> clone -> copy and paste the git url -> click clone.
### Step 2
Download tomcat (if you haven't download it yet), you can refer to more detailed <a href="https://tomcat.apache.org/download-90.cgi">download instruction here<a/>, I recommend you to download version 9, which is compatible with most plugin and system.
### Step 3
Download IDEA plugin <a href="https://plugins.jetbrains.com/plugin/9492-smart-tomcat">smart tomcat<a/> (since that the latest version 2021.3 ultimate no longer support tomcat)
run configuration -> edit Configurations -> Add new Configuration -> select smart tomcat -> tomcat server select your tomcat server, smart tomcat will detect the version automatically -> Server port: 8081 -> Admin port: 8007 -> click run
### Step 4
If it work properly, you should see a page with login and signin button.
