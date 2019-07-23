function addButton() {

    const brand = document.getElementById("brand").value;
    const model = document.getElementById("model").value;
    const year = document.getElementById("year").value;
    const url = "http://localhost:8080/cars";

    let newCar = {"brand": brand, "model": model, "year": year};
    fetch(url, {
        method: "POST",
        body: JSON.stringify(newCar),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(response => {
        console.log(response);
    });
}

function deleteButton(){
}

function updateButton(){

}

function displayRow(){
    let table = document.getElementById("table");
    for (let i = 1; i < table.rows.length; i++) {
        table.rows[i].onclick = function () {
            document.getElementById("car_id").value = this.cells[0].innerHTML;
            document.getElementById("brand").value = this.cells[1].innerHTML;
            document.getElementById("model").value = this.cells[2].innerHTML;
            document.getElementById("year").value = this.cells[3].innerHTML;
        };
    }
}