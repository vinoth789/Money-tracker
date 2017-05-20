<div>
<h1 style="color: #000000; text-align:center;">System Design</h1>
<h2 style="color: #000000; text-align:center;">Welcome to our Third Blog, you will see information about the Interaction and Class diagrams, Design patterns and statergies used in Development process</h2>
</div>

<div>
<h2 style="color: #2e6c80;">Sequence diagram </h2>
<h3 style="color: #2e6c80;">PIN verification use case</h3>
<span align="center">
![usecasediagram image]({{site.baseurl}}/images/MTSeqDgLogin.PNG "Sequence Diagram for Login process")
</span>

<h3 style="color: #2e6c80;">View Report use case</h3>
<span align="center">
![usecasediagram image]({{site.baseurl}}/images/MTSeqDgReport.PNG "Add new transaction")
</span>
</div>

<div>
<h2 style="color: #2e6c80;">Class Diagram for Money Tracker Application :</h2>
<span align="center">
![usecaseDiagram3 image]({{site.baseurl}}/images/MTClassDg.PNG "View report")
</span>

<h3 style="color: #2e6c80;">Detail description of classes and there associations</h3>
<ol>
<li>
<p> User class</p>
<ul>
<li>
Contains attribute PIN of type integer. Accepts PIN of length 4.
</li>
<li>
Contains three methods :
<ul>
<li><p>verifyPIN(int PIN) - verifies if entered pin is of lenght 4 and user authentication</p></li>
<li><p>setPIN(int PIN) - sets passed pin when user has logged in for the first time</p></li>
<li><p>getPIN() - gets PIN on request</p></li>
</ul>
</li>
<ul>
</li>
<li>
Every user after login will be allowed to select one curreny type. Hence user is associated with minimum of one currency type and maxximum of any number of currency types available.
</li>
<li><p></p></li>
</ol>

</div>
<h3 style="color: #000000; text-align:center;">Thanks for visiting our Blog !</h3>

