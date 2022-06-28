/**
 * view-controller for teamedit.html
 * @author Vivek Viruthiyel
 */
document.addEventListener("DOMContentLoaded", () => {
    readTeam();

    document.getElementById("teameditForm").addEventListener("submit", saveTeam);
    document.getElementById("cancel").addEventListener("click", cancelEdit);
});

/**
 * saves the data of a team
 */
function saveTeam(event) {
    event.preventDefault();

    const teamForm = document.getElementById("teameditForm");
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
            headers: {"Content-Type": "application/x-www-form-urlencoded"},
            body: data
        })

        .then(function (response) {
            if (!response.ok) {
                console.log(response);
            } else return response;
        })
        .then()
        .catch(function (error) {
            console.log(error);
        });

}

/**
 * reads a team
 */
function readTeam() {
    const teamUUID = getQueryParam("uuid");
    fetch("./resource/team/read?uuid=" + teamUUID)
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
    document.getElementById("uuid").value = data.name;
    document.getElementById("amountWins").value = data.amountWins;
    document.getElementById("amountLost").value = data.amountLost;
}





/**
 * redirects to the team
 * @param event  the click-event
 */
function cancelEdit(event) {
    window.location.href = "./teamlist.html";
}