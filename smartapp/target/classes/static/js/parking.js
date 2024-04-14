
let parkingData = [
    { level: "Level 1", taken: 13, free: 37 },
    { level: "Level 2", taken: 13, free: 37 },
    { level: "Level 3", taken: 13, free: 37 },
    { level: "Level 4", taken: 13, free: 37 },
    { level: "Level 5", taken: 13, free: 37 }
];


function updateParkingData() {
    let totalTaken = 0;  


    parkingData.forEach((levelData, index) => {
        let takenSpaces = Math.floor(Math.random() * 25) + 1; 
        let freeSpaces = 50 - takenSpaces; 
        levelData.taken = takenSpaces; 
        levelData.free = freeSpaces;
        totalTaken += takenSpaces; 

      
        let levelContainer = document.querySelector(`.parking-level:nth-child(${index + 1})`);
        if (levelContainer) { 
            levelContainer.querySelector('.space.taken').textContent = takenSpaces;
            levelContainer.querySelector('.space.free').textContent = freeSpaces;
        }
    });


    let totalSpaces = 250;
    let availableSpaces = totalSpaces - totalTaken;
    document.getElementById('total-spaces').textContent = totalSpaces;
    document.getElementById('available-spaces').textContent = availableSpaces;
}


updateParkingData();


setInterval(updateParkingData, 3000);
