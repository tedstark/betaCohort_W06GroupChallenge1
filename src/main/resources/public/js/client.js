//Lines 2-6 are code the runs when the DOM (in browser) is complete.
$(document).ready(function(){
    $("#getPeopleBtn").on("click", function(){ //Defines what happens when the getPeopleBtn is clicked.
        getPeople(); //Run the getPeople function
    });
});
//Function that "Gets" the information from the server via AJAX; defined below.
function getPeople() {
    $.ajax({
        type: "GET", //Defines what type of the REST protocol to send;
        url: "/people", //Defines where on the server to send above type;
        success: function (serverData) {//Defines the function to run when type is successful;
                                        // "serverData" is what the return from server will be called.
            console.log(serverData);//Logs out the data from server to browser console;
            appendDOM(serverData.people);//Runs method appendDOM with the argument
                                         //value of the 'people' array from the serverData.
            }
        }
    )
}
//Function that appends/writes the contents of the received 'people' array
// to the defined 'peopleList' DIV over on index.html
function appendDOM(array){
    $("#peopleList").append("<div></div>");//appends new DIV to existing DIV
    var el = $("#peopleList").children().last();//defines the variable 'el' to be the last element of peopleList
    for (var i=0; i<array.length; i++){//For loop to run through the serverData.people array and write all information to the DOM
        el.append("<p>" + array[i].name + " lives in " + array[i].city + ".</p>");
        el.append("<p></p>")
    }
}