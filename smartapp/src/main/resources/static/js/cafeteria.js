document.addEventListener('DOMContentLoaded', function() {
    const menuList = document.getElementById('menu-list');

    // Function to fetch all menu items
    function fetchMenuItems() {
        fetch(`http://localhost:8080/cafeteria/get-all-items`)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok: ' + response.statusText);
                }
                return response.json();
            })
            .then(menuItems => {
                displayMenuItems(menuItems);
            })
            .catch(error => {
                console.error('Error fetching menus:', error);
                menuList.innerHTML = `<li>Error loading menu: ${error.message}</li>`;
            });
    }

    // Function to display menu items in the UI
    function displayMenuItems(menuItems) {
        menuList.innerHTML = ''; // Clear current items
        if (menuItems && menuItems.length > 0) {
            menuItems.forEach(item => {
                const listItem = document.createElement('li');
                listItem.innerHTML = `<strong>${item.mealTime}:</strong> ${item.menuItems}`;
                menuList.appendChild(listItem);
            });
        } else {
            menuList.innerHTML = '<li>No menu items found.</li>';
        }
    }

    // Call the function to fetch menu items on page load
    fetchMenuItems();
});

