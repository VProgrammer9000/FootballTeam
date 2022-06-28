/**
 * view-controller for teamlist.html
 * @author Vivek Viruthiyel
 */
document.addEventListener("DOMContentLoaded", () => {
    readTeams();
});

/**
 * reads all teams
 */
function readTeams() {
    fetch("./resource/team/list")
        .then(function (response) {
            if (response.ok) {
                return response;
            } else {
                console.log(response);
            }
        })
        .then(response => response.json())
        .then(data => {
            showTeamlist(data);
        })
        .catch(function (error) {
            console.log(error);
        });
}

/**
 * shows the teamlist as a table
 * @param data  the teams
 */
function showTeamlist(data) {
    let tBody = document.getElementById("list");
    data.forEach(team => {
        let row = tBody.insertRow(-1);
        row.insertCell(-1).innerHTML = team.name;
        row.insertCell(-1).innerHTML = team.amountWins;
        row.insertCell(-1).innerHTML = team.amountLost;


        let button = document.createElement("button");
        button.innerHTML = "Bearbeiten ...";
        button.type = "button";
        button.name = "editTeam";
        button.setAttribute("data-teamuuid", team.uuid);
        button.addEventListener("click", editTeam);
        row.insertCell(-1).appendChild(button);

        button = document.createElement("button");
        button.innerHTML = "Löschen ...";
        button.type = "button";
        button.name = "deleteTeam";
        button.setAttribute("data-teamuuid", team.uuid);
        button.addEventListener("click", deleteTeam);
        row.insertCell(-1).appendChild(button);

    });
}

/**
 * redirects to the edit-form
 * @param event  the click-event
 */
function editTeam(event) {
    const button = event.target;
    const teamUUID = button.getAttribute("data-teamuuid");
    window.location.href = "./teamedit.html?uuid=" + teamUUID;
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
            method: "DELETE"
        })
        .then(function (response) {
            if (response.ok) {
                window.location.href = "./teamlist.html";
            } else {
                console.log(response);
            }
        })
        .catch(function (error) {
            console.log(error);
        });
}