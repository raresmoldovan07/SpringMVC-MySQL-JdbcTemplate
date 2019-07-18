function submitForm() {
    const brand = document.getElementById("brand").value;
    const model = document.getElementById("model").value;
    const year = document.getElementById("year").value;
    const url = "http://localhost:8080/add";
    var newCar = {"brand": brand, "model": model, "year": year};
    fetch(url, {
        method: "POST",
        body: JSON.stringify(newCar),
        headers: [{
            'Content-Type': 'application/json'
        }]
    }).then(response => {
        console.log(response);
    });
}