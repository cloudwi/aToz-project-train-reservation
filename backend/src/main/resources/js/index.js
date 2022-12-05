const tbody = document.querySelector("#tbody");

fetch("http://localhost:8080/api/v1/schedule")
  .then((response) => response.json())
  .then((data) => {
    data.forEach((schedule, i) => {
      paintSchedule(schedule, i + 1);
    });
  })
  .catch((error) => console.log(error));

function paintSchedule(schedule, i) {
  const tr = document.createElement("tr");
  const th = document.createElement("th");
  const departureTd = document.createElement("td");
  const departureTimeTd = document.createElement("td");
  const arrivalTd = document.createElement("td");
  const arrivalTimeTd = document.createElement("td");
  const carriageTd = document.createElement("td");
  departureTd.innerText = schedule.departure;
  departureTimeTd.innerText = schedule.departureTime;
  arrivalTd.innerText = schedule.arrival;
  arrivalTimeTd.innerText = schedule.arrivalTime;
  carriageTd.innerText = schedule.carriage;

  th.innerText = i;
  tr.appendChild(th);
  tr.appendChild(departureTd);
  tr.appendChild(departureTimeTd);
  tr.appendChild(arrivalTd);
  tr.appendChild(arrivalTimeTd);
  tr.appendChild(carriageTd);
  tbody.appendChild(tr);
}
// fetch("http://localhost:8080/api/v1/schedule", {
//   method: "POST",
//   headers: {
//     "Content-Type": "application/json",
//   },
//   body: JSON.stringify({
//     departure: "Busan",
//     departureTime: "2022-12-05 00:21:00",
//     arrival: "Seoul",
//     arrivalTime: "2022-12-05 02:51:00",
//     carriage: 5,
//   }),
// })
//   .then((response) => console.log(response.json))
//   .catch((error) => console.log(error));

const InputAreaButton = document.querySelector("#InputAreaButton");
InputAreaButton.addEventListener("click", () => {
  fetch("http://localhost:8080/api/v1/area", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      name: document.querySelector("#InputArea").value,
    }),
  })
    .then((response) => location.reload())
    .catch((error) => console.log(error));
});

const inputDeparture = document.querySelector("#InputDeparture");
const inputArrival = document.querySelector("#InputArrival");

fetch("http://localhost:8080/api/v1/area")
  .then((response) => response.json())
  .then((data) => {
    data.forEach((area) => {
      const option = document.createElement("option");
      option.value = area.id;
      option.innerText = area.name;
      inputDeparture.appendChild(option);
    });
  })
  .catch((error) => console.log(error));
fetch("http://localhost:8080/api/v1/area")
  .then((response) => response.json())
  .then((data) => {
    data.forEach((area) => {
      const option = document.createElement("option");
      option.value = area.id;
      option.innerText = area.name;
      inputArrival.appendChild(option);
    });
  })
  .catch((error) => console.log(error));

const InputDepartureTime = document.querySelector("#InputDepartureTime");
InputDepartureTime.addEventListener("click", () => {
  console.log(InputDepartureTime.value);
});

const inputScheduleButton = document.querySelector("#InputScheduleButton");
inputScheduleButton.addEventListener("click", () => {
  fetch("http://localhost:8080/api/v1/schedule", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      departure: document.querySelector("#InputDeparture").value,
      departureTime: document.querySelector("#InputDepartureTime").value,
      arrival: document.querySelector("#InputArrival").value,
      arrivalTime: document.querySelector("#InputArrivalTime").value,
      carriage: document.querySelector("#InputCarriage").value,
    }),
  })
    .then((response) => location.reload())
    .catch((error) => console.log(error));
});
