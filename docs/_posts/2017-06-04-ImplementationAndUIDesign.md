
<h2 style="color: #000000; text-align:center;">Welcome to our third Blog, you will see information about the coding conventions followed, whom this application is meant for and prototype of the MoneyTracker application</h2>

<div>
<h1 style="color: #2e6c80; text-align:center;">Coding Conventions</h1>
<p> A coding standards document tells developers how they must write their code. Instead of each developer coding in their own preferred style, they will write all code to the standards outlined by the organisation or team. This makes sure that a large project is coded in a consistent style and parts are not written differently by different programmers. Not only does this solution make the code easier to understand, but also ensures that any developer who looks at the code will know what to expect throughout the entire application.</p>
<p>Following are the coding conventions that we will be following: </p>
<div>
<ol>
<li><p>The initial package name representing the domain name must be in lower case. For example, de.ovgu.janardhanast.name.login</p></li>
<li><p>Classes are always noun and starts with Uppercase letter followed by lowercase </p></li>
<li><p>Variables always starts with lowercase letter and has mixed case,i.e. it follows camel case convention. Example - Button btnLogin; </p></li>
<li><p>The variables used to store UI components values satrts with the components followed by noun. Example EditText component used to enter UserName will be named as - EditText etUserName;  Radio button that holds income value is named as - RadioButton radiobtnIncome;</p></li>
<li> <p>Functions are always verb and named in accordance to what they do, and are written in lowercase </p></li>
<li><p>Every method and class will hold comments so as to what it does, hence allowing user to quickly understand the functionality</p></li>
<li><p>Constants are always written in Uppercase with underscore seperating the words. Example - int NUMBER_OF_CATEGORY=5;</p></li>
</ol>
</div>
<h2 style="color: #2e6c80;">Question is how do we make sure that all code adeheres to the coding conventions?</h2>
<div>
<ul>
<li><p>Coding standards are defined by discussing with the team, with all the good practices each one is aware of and it has been documented and shared, such that each developer follows the standard </p></li>
<li><p>Once coding is done and tested, code is reviewed by any one of the peer and it is guaranteed if coding conventions are followed and quality of code is maintained </p></li>
<li><p>Comment will be added to the relating issue during code review phase, if the developer fails to meet any standard criterias defined</p></li>
</ul>
<a href="http://www.oracle.com/technetwork/java/codeconvtoc-136057.html">Click here for more details on java coding convention...</a>
</div>
<h2 style="color: #2e6c80;">To whom is our MoneyTracker Application more suitable?</h2>
<p>Money Tracker is general purpose application suitable for every individual who is concerned to maintain or track the expenditure, none the less certain pre-requisites are, one willing to use the application has to be aware about usage of mobile phones, installation of android applications. This application can be better utilized by the pupils with age > 8 years, since it involves mathematically calculated results and representation of expenditure and savings interms of graph and Pie charts. This application is only focused for individuals who wish to track their day today expenses, not for group of peoples or doesn't target large scale industrail expenditure maintainance </p>
<h2>So considering the above factors we can define the two personas whom the application is more suitable is as follows: </h2>

<h2>1. Students away from home</h2>

<div>
<img style="align:center;" src="/isee2017-codecrunch/images/StudentsInHostel.jpg" alt="StudentsInHostel.jpg"/>
<table>
<tr>
<th colspan="4" style="text-align:center; border: solid 2px lightgrey;"><p>Persona</p></th>
<td colspan="8" style="text-align:center; border: solid 2px lightgrey;"><p> Students (Living away from home/ in hostels)</p></td>
</tr>

<tr>
<th colspan="4" style="text-align:center; border: solid 2px lightgrey;"><p>Fictional name</p></th>
<td colspan="8" style="text-align:center; border: solid 2px lightgrey;"><p> Rajesh Koothrapali</p></td>
</tr>

<tr>
<th colspan="4" style="text-align:center; border: solid 2px lightgrey;"><p>Major Responsibilities</p></th>
<td colspan="8" style="text-align:center; border: solid 2px lightgrey;"><p> Master Student in Digital Engineering and works as Reseacrch assistant</p></td>
</tr>

<tr>
<th colspan="4" style="text-align:center; border: solid 2px lightgrey;"><p>Demographics</p></th>
<td colspan="8" style="text-align:center; border: solid 2px lightgrey;"><p> 23 year old, Master Student in Digital Engineering, Indian and Unmarried</p></td>
</tr>

<tr>
<th colspan="4" style="text-align:center; border: solid 2px lightgrey;"><p>Goals and tasks</p></th>
<td colspan="8" style="text-align:center; border: solid 2px lightgrey;"><p> As a student and one living away from home, it is very necessary to have a clear idea on how much expense he can bare per month for every category like education , entertainment, travelling and groceries, based on his monthly income and also savings he is planning for the future </p></td>
</tr>

<tr>
<th colspan="4" style="text-align:center; border: solid 2px lightgrey;"><p>Environment</p></th>
<td colspan="8" style="text-align:center; border: solid 2px lightgrey;"><p>As a student it is more likely to party or involve oneself in carrying out projects of interest and one may tend to spend more on any of this field</p></td>
</tr>

<tr>
<th colspan="4" style="text-align:center; border: solid 2px lightgrey;"><p>Quote</p></th>
<td colspan="8" style="text-align:center; border: solid 2px lightgrey;"><p>Do not save what is left after spending, spend what is left after saving!!</p></td>
</tr>
</table>
</div>

<h2>2. Family Maintenance</h2>
<img style="align:center;" src="/isee2017-codecrunch/images/Family.png" alt="Family.png"/>
<div>
<table>
<tr>
<th colspan="4" style="text-align:center; border: solid 2px lightgrey;"><p>Persona</p></th>
<td colspan="8" style="text-align:center; border: solid 2px lightgrey;"><p> Head of the family/ Father or Mother</p></td>
</tr>

<tr>
<th colspan="4" style="text-align:center; border: solid 2px lightgrey;"><p>Fictional name</p></th>
<td colspan="8" style="text-align:center; border: solid 2px lightgrey;"><p> Erlich Bochman</p></td>
</tr>

<tr>
<th colspan="4" style="text-align:center; border: solid 2px lightgrey;"><p>Major Responsibilities</p></th>
<td colspan="8" style="text-align:center; border: solid 2px lightgrey;"><p> Works as software engineer</p></td>
</tr>

<tr>
<th colspan="4" style="text-align:center; border: solid 2px lightgrey;"><p>Demographics</p></th>
<td colspan="8" style="text-align:center; border: solid 2px lightgrey;"><p> 30 year old, Software engineer , German and Married</p></td>
</tr>

<tr>
<th colspan="4" style="text-align:center; border: solid 2px lightgrey;"><p>Goals and tasks</p></th>
<td colspan="8" style="text-align:center; border: solid 2px lightgrey;"> <p>As a family person it is very important to maintain the expenses of family members within the flowing in income</p>
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
<td colspan="8" style="text-align:center; border: solid 2px lightgrey;"><p>Spending will be more on socializing events rather than for technological events</p></td>
</tr>

<tr>
<th colspan="4" style="text-align:center; border: solid 2px lightgrey;"><p>Quote</p></th>
<td colspan="8" style="text-align:center; border: solid 2px lightgrey;"><p>Save your Money!! you are going to need twice as much as MONEY in your old age then you think!!</p> </td>
</tr>

</table>
</div>

<h2 style="color: #2e6c80;">Mockup of MoneyTracker application :</h2>
<p>Below is the prototype of Money Tracker application </p>

<div>
<h2>1. Enabling Login in Settings window</h2>
<p>Shows the paper prototype for enabling of login action. From settings one can enable Login option and on entering the application for the next time, authentication and authorisation actions are performed. </p>
 <img style="align:center;" src="/isee2017-codecrunch/images/LoginEnabling.png" alt="EnableLogin.png"/>  
</div>

<div>
<h2>2. Adding Transactions (Income or Expense)</h2>
<p>Shows the paper prototype for adding the Transaction. User can choose Income or Expense type and navigate to Add Transaction window where he/she will be asked to select subcategory of selected Income/Expense type, amount and Date. Once done filling and saving transaction, it's data will be updated in Homescreen.  </p>
<img style="align:center;" src="/isee2017-codecrunch/images/AddTransaction.png" alt="TransactionPaperMockUp.jpg"/> 
</div>

<div>
<h1>User Interfaces</h1>
<h2>1. Login</h2>
<h2>2. Settings</h2>
<h2>3. Add Transaction</h2>
</div>

<h3 style="color: #000000; text-align:center;">Thanks for visiting our Blog !</h3>

