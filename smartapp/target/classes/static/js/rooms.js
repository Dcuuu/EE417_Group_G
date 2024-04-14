
document.addEventListener('DOMContentLoaded', function () {
    fetchClassroomData();
});

function fetchClassroomData() {
    fetch('/classrooms/occupancy-details')
    .then(response => response.json())
    .then(data => updateRoomAvailability(data))
    .catch(error => console.error('Error fetching data: ', error));
}

function updateRoomAvailability(data) {
     console.log("Received data:", data);
    data.forEach((room, index) => {
        const floorIndex = index + 1;
        const totalRoomsElement = document.getElementById(`total-rooms-floor${floorIndex}`);
        const roomsTakenElement = document.getElementById(`rooms-taken-floor${floorIndex}`);
        const roomsFreeElement = document.getElementById(`rooms-free-floor${floorIndex}`);


        totalRoomsElement.textContent = room.isOccupied ? "Taken" : "Available";
        roomsTakenElement.textContent = room.isOccupied ? room.capacity : 0; 
        roomsFreeElement.textContent = room.isOccupied ? 0 : room.capacity;
    });
}

