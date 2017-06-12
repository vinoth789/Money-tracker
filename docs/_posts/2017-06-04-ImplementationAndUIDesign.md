
<h2 style="color: #000000; text-align:center;">Welcome to our third Blog, you will see information about the coding conventions followed, whom this application is meant for and prototype of the MoneyTracker application</h2>

<div>
<h1 style="color: #2e6c80; text-align:center;">Coding Conventions</h1>
<p> A coding standards document tells developers how they must write and present their code. Since the standard set is going to remain the same, its always a good practice to follow the coding standards so that its gonna make things easier to undersatand and more clear to the other developers working on the same application.  Instead of each developer coding in their own preferred style, they will write all code to the standards outlined by the organisation or team. This makes sure that a large project is coded in a consistent style and parts are not written differently by different programmers. Not only does this solution make the code easier to understand, but also ensures that any developer who looks at the code will be able to get a clear picture on the structure of entire application.</p>
<p>Following are the coding conventions that we will be followed by our team: </p>
<h2 style="color: #2e6c80;">1.1 Naming conventions</h2>
<div>
<ol>
<li><p>The initial package name representing the domain name must be in lower case. For example, de.ovgu.janardhanast.name.login</p></li>
<li><p>Classes are always noun and are written in UpperCamelCase.<br> Example: SignInActivity.java</p></li>
<li><p>Variables always starts with lowercase letter and has mixed case,i.e. it follows camel case convention. <br> Example : Button btnLogin; </p></li>
<li><p>The variables used to store UI components values satrts with the components followed by noun. <br> Example EditText component used to enter UserName will be named as - EditText etUserName; <br> Radio button that holds income value is named as - RadioButton radiobtnIncome;</p></li>
<li> <p>Functions are always verb and named in accordance to what they do, and are written in lowercase </p></li>
<li><p>Every method and class will hold comments so as to what it does, hence allowing user to quickly understand the functionality</p></li>
<li><p>Constants are always written in Uppercase with underscore seperating the words.<br> Example - int NUMBER_OF_CATEGORY=5;</p></li>
</ol>
</div>
<h2 style="color: #2e6c80;">1.2 Layout files:</h2>
<p>Layout files should match the name of the Android components that they are intended for.
Example : if we are creating a layout for the LoginActivity, the name of the layout file should be activity_login.xml.
</p>
<h2 style="color: #2e6c80;">1.3 Values files:</h2>
<p>Resource files in the values folder should be plural,<br><b>Example : </b> strings.xml, styles.xml, colors.xml, dimens.xml, attrs.xml</p>
<h2 style="color: #2e6c80;">1.4 File import:</h2>
<p>While importing a file, the import statement should have the complete file name prefixed by its package name.<br> Example :</b> import com.example.sony.homeMain.MainActivity;</p>
<h2 style="color: #2e6c80;">1.5 Exception handling:</h2>
<p>All possible and expected exceptions are to be handled by using a try catch block with appropriate exceptions in the catch block <br> <b>Example :</b> <br>
try {<br>
   // Protected code<br>
}catch(ExceptionName e1) {<br>
   // Catch block<br>
}
</p>
<h2 style="color: #2e6c80;">1.6 Space indentation:</h2>
<p>4 space indents should be used for blocks:<br>
<b>Example : </b><br>
if (switchState == true) {<br>
    //content<br>
}
</p>
<h2 style="color: #2e6c80;">1.7 Brace style:</h2>
<p>Braces go on the same line as the code. If the condition has multiple statements, it should be covered inside the braces.<br>
<b>Example :</b><br>
If (isPinValid) {<br>
    Intent intent = new Intent(this, MainActivity.class );<br>
    startActivity(intent);<br>
} else {<br>
    Intent intent = new Intent(this, LoginToHome.class);<br>
    startActivity(intent);<br>
}
</p>
<h2 style="color: #2e6c80;">1.8 Logging </h2>
<p>Logging methods has to be used since we work as a team. We might not know whose file throws an error. If all these are captured in a log it will be quite useful for fellow developers.
<b>Example :</b><br>
public validatePin() {<br>
        Log.e(TAG, "Inside validate PIN method");<br>
    }<br>
</p>
<h2 style="color: #2e6c80;">1.9 Code format </h2>
<p>Format the code once coding has been completed in a page using Ctrl+Alt+l</p>

<h2 style="color: #2e6c80;">Question is how do we make sure that all code adeheres to the coding conventions?</h2>
<div>
<ul>
<li><p>Coding standards are defined by discussing with the team, with all the good practices each one is aware of and it has been documented and shared, such that each developer follows the standard </p></li>
<li><p>Once coding is done and tested, code is reviewed by any one of the peer and it is guaranteed if coding conventions are followed and quality of code is maintained </p></li>
<li><p>Comment will be added to the related issue during code review phase, if the developer fails to meet any standard criterias that has been defined</p></li>
</ul>
<a href="http://www.oracle.com/technetwork/java/codeconvtoc-136057.html">Click here for more details on java coding convention...</a>
</div>
<h2 style="color: #2e6c80;">To whom is our MoneyTracker Application more suitable?</h2>
<p>Money Tracker is general purpose application suitable for every individual who is concerned to maintain or track the expenditure, none the less certain pre-requisites are, one willing to use the application has to be aware about usage of mobile phones, installation of android applications. This application can be better utilized by the pupils with age > 8 years, since it involves mathematically calculated results and representation of expenditure and savings interms of graph and Pie charts. This application is only focused for individuals who wish to track their day to day expenses, not for group of people or doesn't target large scale industrial expenditure maintainance </p>
<h2>So considering the above factors we can define the two personas whom the application is more suitable is as follows: </h2>

<h2 style="color: #2e6c80;">1. Students away from home</h2>

<div>
<img style="align:center;" src="/isee2017-codecrunch/images/StudentsInHostel.jpg" alt="StudentsInHostel.jpg"/>
<table>
<tr>
<th colspan="4" style="text-align:center; border: solid 2px lightgrey;"><p>Persona</p></th>
<td colspan="8" style="border: solid 2px lightgrey;"><p>&nbsp; Students (Living away from home/ in hostels)</p></td>
</tr>

<tr>
<th colspan="4" style="text-align:center; border: solid 2px lightgrey;"><p>Fictional name</p></th>
<td colspan="8" style="border: solid 2px lightgrey;"><p>&nbsp; Sandra Schroder</p></td>
</tr>

<tr>
<th colspan="4" style="text-align:center; border: solid 2px lightgrey;"><p>Major Responsibilities</p></th>
<td colspan="8" style="border: solid 2px lightgrey;"><p>&nbsp; Master Student in Digital Engineering and works as Reseacrch assistant</p></td>
</tr>

<tr>
<th colspan="4" style="text-align:center; border: solid 2px lightgrey;"><p>Demographics</p></th>
<td colspan="8" style="border: solid 2px lightgrey;"><p>&nbsp; 23 year old, Master Student in Digital Engineering, Indian and Unmarried</p></td>
</tr>

<tr>
<th colspan="4" style="text-align:center; border: solid 2px lightgrey;"><p>Goals and tasks</p></th>
<td colspan="8" style="border: solid 2px lightgrey;"><p>&nbsp; As a student and one living away from home, it is very necessary to have a clear idea on how much expense he <br>&nbsp; can bare per month for every category like education , entertainment, travelling and groceries, based on his <br> &nbsp; monthly income and also savings he is planning for the future </p></td>
</tr>

<tr>
<th colspan="4" style="text-align:center; border: solid 2px lightgrey;"><p>Environment</p></th>
<td colspan="8" style="border: solid 2px lightgrey;"><p> &nbsp; As a student it is more likely to party or involve oneself in carrying out projects of interest and one may tend to <br> &nbsp; spend more on any of this field</p></td>
</tr>

<tr>
<th colspan="4" style="text-align:center; border: solid 2px lightgrey;"><p>Quote</p></th>
<td colspan="8" style="border: solid 2px lightgrey;"><p>&nbsp; Do not save what is left after spending, spend what is left after saving!!</p></td>
</tr>
</table>
</div>

<h2 style="color: #2e6c80;">2. Family Maintenance</h2>
<img style="align:center;" src="/isee2017-codecrunch/images/Family.png" alt="Family.png"/>
<div>
<table>
<tr>
<th colspan="4" style="text-align:center; border: solid 2px lightgrey;"><p>Persona</p></th>
<td colspan="8" style="border: solid 2px lightgrey;"><p>&nbsp; Head of the family/ Father or Mother</p></td>
</tr>

<tr>
<th colspan="4" style="text-align:center; border: solid 2px lightgrey;"><p>Fictional name</p></th>
<td colspan="8" style="border: solid 2px lightgrey;"><p> &nbsp; Erlich Bochman</p></td>
</tr>

<tr>
<th colspan="4" style="text-align:center; border: solid 2px lightgrey;"><p>Major Responsibilities</p></th>
<td colspan="8" style="border: solid 2px lightgrey;"><p> &nbsp; Works as software engineer</p></td>
</tr>

<tr>
<th colspan="4" style="text-align:center; border: solid 2px lightgrey;"><p>Demographics</p></th>
<td colspan="8" style="border: solid 2px lightgrey;"><p>&nbsp; 30 year old, Software engineer , German and Married</p></td>
</tr>

<tr>
<th colspan="4" style="text-align:center; border: solid 2px lightgrey;"><p>Goals and tasks</p></th>
<td colspan="8" style="border: solid 2px lightgrey;"> <p> &nbsp; As a family person it is very important to maintain the expenses of family members within the flowing in <br> &nbsp; income</p>
<ul>
<li><p>Monthly rental/ house maintenance</p></li>
<li><p>Education of kids</p></li>
<li><p>Health, entertainment and travelling</p></li>
<li><p>Savings for future</p></li>
</ul>
</td>
</tr>

<tr>
<th colspan="4" style="text-align:center; border: solid 2px lightgrey;"><p>Environment</p></th>
<td colspan="8" style="border: solid 2px lightgrey;"><p>&nbsp; Spending will be more on socializing events rather than for technological events</p></td>
</tr>

<tr>
<th colspan="4" style="text-align:center; border: solid 2px lightgrey;"><p>Quote</p></th>
<td colspan="8" style="border: solid 2px lightgrey;"><p>&nbsp; Save your Money!! you are going to need twice as much as MONEY in your old age than you think!!</p> </td>
</tr>

</table>
</div>

<h1 style="color: #2e6c80; text-align:center;">Mockup of MoneyTracker application :</h1>
<p>Below is the prototype of Money Tracker application </p>

<div>
<h2 style="color: #2e6c80;">1. Enabling Login in Settings window</h2>
<p>Shows the paper prototype for enabling of login action. From settings one can enable Login option and on entering the application for the next time, authentication and authorisation actions are performed. </p>
 <img style="align:center;" src="/isee2017-codecrunch/images/LoginEnabling.png" alt="EnableLogin.png"/>  
</div>

<div>
<h2 style="color: #2e6c80;">2. Adding Transactions (Income or Expense)</h2>
<p>Shows the paper prototype for adding the Transaction. User can choose Income or Expense type and navigate to Add Transaction window where he/she will be asked to select subcategory of selected Income/Expense type, amount and Date. Once done filling and saving transaction, it's data will be updated in Homescreen.  </p>
<img style="align:center;" src="/isee2017-codecrunch/images/AddTransaction.png" alt="TransactionPaperMockUp.jpg"/> 
</div>

<div>
<h1 style="color: #2e6c80; text-align:center;">User Interfaces</h1>
<h2 style="color: #2e6c80;">1. Login</h2>
<h2 style="color: #2e6c80;">2. Settings</h2>
<h2 style="color: #2e6c80;">3. Add Transaction</h2>
</div>

<h3 style="color: #000000; text-align:center;">Thanks for visiting our Blog !</h3>

