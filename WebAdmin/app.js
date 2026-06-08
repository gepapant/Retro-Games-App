const API_URL = "http://localhost:8080/games";

if(document.getElementById("gamesTable")) {

    fetch(API_URL)

        .then(response => response.json())

        .then(data => {

            let table =
                document.getElementById("gamesTable");

            data.forEach(game => {

                let row =

                    `<tr>

                        <td>${game.id}</td>

                        <td>${game.title}</td>

                        <td>${game.platform}</td>

                        <td>${game.releaseDate}</td>

                    </tr>`;

                table.innerHTML += row;
            });
        });
}

if(document.getElementById("gameForm")) {

    document
        .getElementById("gameForm")
        .addEventListener("submit",

            function(e){

                e.preventDefault();

                let game = {

                    title:
                        document
                            .getElementById("title").value,

                    platform:
                        document
                            .getElementById("platform").value,

                    releaseDate:
                        document
                            .getElementById("releaseDate").value,

                    description:
                        document
                            .getElementById("description").value
                };

                fetch(API_URL, {

                    method: "POST",

                    headers: {

                        "Content-Type":
                            "application/json"
                    },

                    body:
                        JSON.stringify(game)
                })

                    .then(() => {

                        alert("Game saved");
                    });
            });
}
