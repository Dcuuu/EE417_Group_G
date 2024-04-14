// carousel.js

document.addEventListener('DOMContentLoaded', (event) => {
    const imagePaths = [
        'images/scroll1.jpg',
        'images/scroll2.jpg',
        'images/scroll3.jpg',
        'images/scroll4.jpg',
        'images/scroll5.jpg'
    ];
    let currentIndex = 0;
    const imageElement = document.getElementById('carousel-image');

    function changeImage() {
        // Fade out the image
        imageElement.classList.add('fade');
        setTimeout(() => {
            currentIndex = (currentIndex + 1) % imagePaths.length; // Cycle through the array
            imageElement.src = imagePaths[currentIndex];
            // Fade the image back in
            imageElement.classList.remove('fade');
        }, 1000); // This timeout should match the fade-out duration
    }
  
    // Set the interval to 5 seconds (5000 milliseconds)
    setInterval(changeImage, 5000);
});
