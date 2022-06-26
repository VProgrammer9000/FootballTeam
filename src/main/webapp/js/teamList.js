/**
 * view-controller for teamList.html
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
    let tBody = document.getElementById("teamList");
    data.forEach(team => {
        let row = tBody.insertRow(-1);
        row.insertCell(-1).innerHTML = team.teamName;
        row.insertCell(-1).innerHTML = team.teamAmountWins;
        row.insertCell(-1).innerHTML = team.teamAmountLost;

        let button = document.createElement("button");
        button.innerHTML = "Bearbeiten ...";
        button.type = "button";
        button.name = "editTeam";
        button.setAttribute("data-teamuuid", team.teamUUID);
        button.addEventListener("click", editTeam);
        row.insertCell(-1).appendChild(button);

        button = document.createElement("button");
        button.innerHTML = "Löschen ...";
        button.type = "button";
        button.name = "deleteTeam";
        button.setAttribute("data-teamuuid", team.teamUUID);
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
                window.location.href = "./teamList.html";
            } else {
                console.log(response);
            }
        })
        .catch(function (error) {
            console.log(error);
        });
}