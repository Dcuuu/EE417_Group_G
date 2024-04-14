document.addEventListener('DOMContentLoaded', function() {
	const form = document.getElementById('menuForm');
	const menuTableBody = document.getElementById('menuTable').getElementsByTagName('tbody')[0];

	// Fetch menu items on page load
	fetchMenus();

	// Add event listener to form submission
	form.addEventListener('submit', function(event) {
		event.preventDefault();
		const menuId = form.menuId.value;
		const date = form.date.value;
		const mealTime = form.mealTime.value;
		const menuItems = form.menuItems.value;

		const menu = { menuId, date, mealTime, menuItems };

		if (menuId) {
			updateMenu(menuId, menu);
		} else {
			addMenu(menu);
		}
	});

	// Function to fetch all menu items
	function fetchMenus() {
		fetch('/cafeteria/get-all-items')
			.then(response => response.json())
			.then(data => {
				menuTableBody.innerHTML = '';

				data.forEach(menu => {
					const row = menuTableBody.insertRow();
					row.innerHTML = `
                        <td>${menu.menuId}</td>
                        <td>${menu.date}</td>
                        <td>${menu.mealTime}</td>
                        <td>${menu.menuItems}</td>
                        <td>
                            <button onclick="editMenu(${menu.menuId})">Edit</button>
                            <button onclick="deleteMenu(${menu.menuId})">Delete</button>
                        </td>
                    `;
				});
			})
			.catch(error => {
				console.error('Error fetching menus:', error);
			});
	}
	// Helper function to format date from "dd-MM-yyyy" to "yyyy-MM-dd"
	function formatDateString(dateStr) {
		const parts = dateStr.split('-');
		return `${parts[2]}-${parts[1]}-${parts[0]}`;  // Change this line if date input is in another format
	}


	addButton.addEventListener('click', function(event) {
		event.preventDefault();

		const menuId = document.getElementById('menuId').value;
		const date = formatDateString(document.getElementById('date').value);  // Format date here
		const mealTime = document.getElementById('mealTime').value;
		const menuItems = document.getElementById('menuItems').value;

		const menuData = {
			menuId,
			date,
			mealTime,
			menuItems
		};

		fetch('/cafeteria/addMenu', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(menuData)
		})
			.then(response => {
				if (!response.ok) {
					throw new Error('HTTP status ' + response.status);
				}
				return response.json();
			})
			.then(data => {
				console.log('Success:', data);
				alert('New menu added successfully!');
				form.reset();  // Reset form after successful addition
				fetchMenus();  // Fetch all menus again to update the list
			})
			.catch((error) => {
				console.error('Error:', error);
				alert('Failed to add menu.');
			});
	});



	// Function to update an existing menu
	function updateMenu(menuId, menu) {
		fetch(`/cafeteria/updateMenu/${menuId}`, {
			method: 'PUT',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(menu)
		})
			.then(response => {
				if (response.ok) {
					form.reset();
					fetchMenus(); 
				} else {
					throw new Error('Failed to update menu');
				}
			})
			.catch(error => {
				console.error('Error updating menu:', error);
			});
	}


	// Function to delete a menu
	window.deleteMenu = function(menuId) {
		if (confirm('Are you sure you want to delete this menu?')) {
			fetch(`/cafeteria/deleteMenu/${menuId}`, {
				method: 'DELETE'
			})
				.then(() => {
					fetchMenus();
				})
				.catch(error => {
					console.error('Error deleting menu:', error);
				});
		}
	};

	// Function to edit a menu
	window.editMenu = function(menuId) {
		fetch(`/cafeteria/getMenuById/${menuId}`)
			.then(response => response.json())
			.then(data => {
				form.menuId.value = data.menuId;
				form.date.value = data.date;
				form.mealTime.value = data.mealTime;
				form.menuItems.value = data.menuItems;
			})
			.catch(error => {
				console.error('Error fetching menu details:', error);
			});
	};
});
