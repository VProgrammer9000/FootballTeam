/**
 * view-controller for teamList.html
 * @author Marcel Suter
 */
let delayTimer;

document.addEventListener("DOMContentLoaded", () => {
    readTeams("","");

    document.getElementById("search").addEventListener("keyup", searchTeams);
});

function readTeams() {
    let url = "./resource/team/list";
    fetch(url, {
        headers: { "Authorization": "Bearer " + readStorage("token")}
    })
        .then(function (response) {
            if (response.ok) {
                return response;
            } else {
                console.log(response);
            }
        })
        .then(response => response.json())
        .then(data => {
            showTeamList(data);
        })
        .catch(function (error) {
            console.log(error);
        });
}


/**
 * shows the teams as a table
 * @param data  the teams
 */
function showTeamList(data) {
    const userRole = getCookie("userRole");
    let tBody = document.getElementById("teamList");
    tBody.innerHTML = "";
    data.forEach(team => {
        let row = tBody.insertRow(-1);

        let button = document.createElement("button");
        if (userRole === "user" || userRole === "admin")
            button.innerHTML = "&#9998;";
        else
            button.innerHTML = "&#128065;";

        button.type = "button";
        button.name = "editBook";
        button.setAttribute("data-teamuuid", team.teamUUID);
        button.addEventListener("click", editTeam);
        row.insertCell(-1).appendChild(button);

        row.insertCell(-1).innerHTML = team.teamName;


        if (userRole === "admin") {
            button = document.createElement("button");
            button.innerHTML = "&#128465;";
            button.type = "button";
            button.name = "deleteBook";
            button.setAttribute("data-teamuuid", team.teamUUID);
            button.addEventListener("click", deleteTeam);
            row.insertCell(-1).appendChild(button);
        }

    });

    if (userRole === "user" || userRole === "admin") {
        document.getElementById("addButton").innerHTML = "<a href='./teamEdit.html'>Neues Buch</a>";
    }
}

/**
 * redirects to the edit-form
 * @param event  the click-event
 */
function editTeam(event) {
    const button = event.target;
    const teamUUID = button.getAttribute("data-teamuuid");
    window.location.href = "./teamEdit.html?uuid=" + teamUUID;
}

/**
 * deletes a team
 * @param event  the click-event
 */
function deleteTeam(event) {
    const button = event.target;
    const teamUUID = button.getAttribute("data-teamuuid");

    fetch("./resource/team/delete?uuid=" + teamUUID,
        {
            method: "DELETE",
            headers: { "Authorization": "Bearer " + readStorage("token")}
        })
        .then(function (response) {
            if (response.ok) {
                window.location.href = "../teamList.html";
            } else {
                console.log(response);
            }
        })
        .catch(function (error) {
            console.log(error);
        });
}