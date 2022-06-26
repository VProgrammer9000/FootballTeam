/**
 * view-controller for playerEdit.html
 * @author Marcel Suter
 */
document.addEventListener("DOMContentLoaded", () => {
    readTeam();

    document.getElementById("teamEditForm").addEventListener("submit", saveTeam);
    document.getElementById("cancel").addEventListener("click", cancelEdit);
});

/**
 * saves the data of a team
 */
function saveTeam(event) {
    event.preventDefault();
    showMessage("", "info");

    const teamForm = document.getElementById("teamEditForm");
    const formData = new FormData(teamForm);
    const data = new URLSearchParams(formData);

    let method;
    let url = "./resource/team/";
    const teamUUID = getQueryParam("uuid");
    if (teamUUID == null) {
        method = "POST";
        url += "create";
    } else {
        method = "PUT";
        url += "update";
    }

    fetch(url,
        {
            method: method,
            headers: {
                "Content-Type": "application/x-www-form-urlencoded",
                "Authorization": "Bearer " + readStorage("token")
            },
            body: data
        })
        .then(function (response) {
            if (!response.ok) {
                showMessage("Fehler beim Speichern", "error");
                console.log(response);
            } else {
                showMessage("Buch gespeichert", "info");
            return response;}
        })
        .catch(function (error) {
            console.log(error);
        });
}

/**
 * reads a team
 */
function readTeam() {
    const teamUUID = getQueryParam("uuid");
    fetch("./resource/team/read?uuid=" + teamUUID, {
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
            showTeam(data);
        })
        .catch(function (error) {
            console.log(error);
        });
}

/**
 * show the data of a team
 * @param data  the team-data
 */
function showTeam(data) {
    const userRole = getCookie("userRole");
    document.getElementById("teamUUID").value = data.teamUUID;
    document.getElementById("teamName").value = data.teamName;

    const locked =  !(userRole === "user" || userRole === "admin");
    lockForm("teamEditForm", locked);
}

/**
 * redirects to the teamlist
 * @param event  the click-event
 */
function cancelEdit(event) {
    window.location.href = "../teamList.html";
}