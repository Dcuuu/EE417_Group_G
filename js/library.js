
document.addEventListener('DOMContentLoaded', function() {
	fetchLibraryVisitors();

	function fetchLibraryVisitors() {
		fetch('/library/visitors')
			.then(response => response.json())
			.then(data => drawChart(data))
			.catch(error => console.error('Error fetching visitor data:', error));
	}

	function drawChart(data) {
		const ctx = document.getElementById('visitorsChart').getContext('2d');
		const labels = data.map(visitor => new Date(visitor.date).toLocaleDateString());
		const dataPoints = data.map(visitor => visitor.currentCount);

		const visitorsChart = new Chart(ctx, {
			type: 'line',
			data: {
				labels: labels,
				datasets: [{
					label: 'Number of Visitors',
					data: dataPoints,
					fill: false,
					borderColor: 'rgb(75, 192, 192)',
					backgroundColor: 'rgba(75, 192, 192, 0.5)', // Light blue fill color
					tension: 0.1
				}]
			},
			options: {
				scales: {
					y: {
						beginAtZero: true,
						ticks: {
							color: 'white' // Set y-axis ticks to white
						}
					},
					x: {
						ticks: {
							color: 'white' // Set x-axis ticks to white
						}
					}
				},
				plugins: {
					legend: {
						labels: {
							color: 'white' // Set legend labels to white
						}
					}
				},
				responsive: true,
				maintainAspectRatio: false
			}
		});
	}
});




