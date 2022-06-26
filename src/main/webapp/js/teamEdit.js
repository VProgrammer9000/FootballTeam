/**
 * view-controller for teamEdit.html
 * @author Marcel Suter
 */
document.addEventListener("DOMContentLoaded", () => {
    /*readPublishers();*/
    readTeam();

    document.getElementById("teamEditForm").addEventListener("submit", saveTeam);
    document.getElementById("cancel").addEventListener("click", cancelEdit);
});

/**
 * saves the data of a team
 */
function saveTeam(event) {
    event.preventDefault();

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
                "Content-Type": "application/x-www-form-urlencoded"
            },
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
    document.getElementById("teamUUID").value = data.teamUUID;
    document.getElementById("teamName").value = data.teamName;
    document.getElementById("teamAmountWins").value = data.teamAmountWins;
    document.getElementById("teamAmountLost").value = data.teamAmountLost;
}

/**
 * reads all publishers as an array
 */
/*
function readPublishers() {

    fetch("./resource/publisher/list")
        .then(function (response) {
            if (response.ok) {
                return response;
            } else {
                console.log(response);
            }
        })
        .then(response => response.json())
        .then(data => {
            showPublishers(data);
        })
        .catch(function (error) {
            console.log(error);
        });
}
*/
/**
 * shows all publishers as a dropdown
 * @param data
 */
/*
function showPublishers(data) {
    let dropdown = document.getElementById("publisher");
    data.forEach(publisher => {
        let option = document.createElement("option");
        option.text = publisher.publisher;
        option.value = publisher.publisherUUID;
        dropdown.add(option);
    })
}
*/
/**
 * redirects to the teamList
 * @param event  the click-event
 */
function cancelEdit(event) {
    window.location.href = "./teamList.html";
}