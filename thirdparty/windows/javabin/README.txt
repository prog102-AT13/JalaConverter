ADDING JAVA BIN TO THE PROJECT

In order to add java bin and use for compiling, follow the next steps.
 
1. Go to https://www.oracle.com/java/technologies/javase-downloads.html

2. Click on link "JDK Download" in Section "Oracle JDK" of the desired version (In this case Java SE 11 (LTS))

3. Search for "Windows x64 Compressed Archive" in the "Product / File Description" column

4. Click on the respective link provided in the "Download" column 

5. The file downloaded is going to be .zip (In this case jdk-11.0.10_windows-x64_bin.zip)

6. Open the file

7. Extract the file inside the project, in the "thirdparty\windows\javabin" folder

8. Go to "src\main\java\org\fundacion\jala\converter\javacompiler\JavaVersion.java" java class. 

	- A variable with the location of javac.exe and java.exe in the bin folder for java 11 is already created. 
	- If added other versions of java, a new variable needs to be created 
	  Example:
		JAVA_11 ("\"thirdparty\\windows\\javabin\\jdk-11.0.10\\bin\\javac.exe\"", "\"thirdparty\\windows\\javabin\\jdk-11.0.10\\bin\\java.exe\"");
