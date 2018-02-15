$(document).ready(function(){
    console.log("DOM is ready");
    $("#getPeopleBtn").on("click", function(){
        getPeople();
    });
});

function getPeople() {
    console.log("next send ajax");
    $.ajax({
        type: "GET",
        url: "/people",
        success: function (serverData) {
            console.log("Server Responded");
            console.log(serverData);
            appendDOM(serverData.people);
            }
        }
    )
}

function appendDOM(array){
    $("#peopleList").append("<div></div>");
    var el = $("#peopleList").children().last();


    for (var i=0; i<array.length; i++){

        el.append("<p>" + array[i].name + " lives in " + array[i].city + ".</p>");
        el.append("<p></p>")
    }
}