document.addEventListener('DOMContentLoaded', function() {
    var mapImg = document.querySelector('.campus-map');
    var scale = 1;
    var originX = 0;
    var originY = 0;

    mapImg.addEventListener('click', function(event) {
        // Only zoom in if the current scale is 1
        if (scale === 1) {
            // Get the dimensions of the image
            var rect = mapImg.getBoundingClientRect();
            // Calculate the click position relative to the image
            originX = ((event.clientX - rect.left) / rect.width) * 100;
            originY = ((event.clientY - rect.top) / rect.height) * 100;
            
            // Apply the origin based on the click
            mapImg.style.transformOrigin = `${originX}% ${originY}%`;
            // Zoom in
            scale = 4;
        } else {
            // Reset the origin
            mapImg.style.transformOrigin = 'center center';
            // Zoom out
            scale = 1;
        }

        mapImg.style.transform = `scale(${scale})`;
    });
});
