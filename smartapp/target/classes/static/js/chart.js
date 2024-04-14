// Line Chart
        var ctxLine = document.getElementById('lineChart').getContext('2d');
var lineChart = new Chart(ctxLine, {
    type: 'line',
    data: {
        labels: ['Day 1', 'Day 2', 'Day 3', 'Day 4', 'Day 5', 'Day 6', 'Day 7'], 
        datasets: [{
            label: 'Monthly Temperature',
            data: [12,14,12,14,13,12,12.5],
            backgroundColor: 'rgba(255, 99, 132, 0.2)',
            borderColor: 'rgba(255, 99, 132, 1)',
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: false
            }
        }
    }
});


        // Bar Chart
       var ctxBar = document.getElementById('barChart').getContext('2d');
var barChart = new Chart(ctxBar, {
    type: 'bar',
    data: {
        labels: ['Morning', 'Afternoon', 'Evening', 'Night'], 
        datasets: [{
            label: 'Daily Footfall',
            data: [100,487,200,20],
            backgroundColor: [
                'rgba(255, 206, 86, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255, 206, 86, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});


        // Scatter Chart with Plotly
        var trace1 = {
    x: [1, 2, 3, 4, 5,6,7,8,9,10,11,12], // month
    y: [10, 15, 13, 17, 10,12,11,10,13,15,11,17], // data
    mode: 'markers',
    type: 'scatter'
};
var dataScatter = [trace1];
var layoutScatter = {
    title: 'Annual Air Quality Scatter Plot',
    xaxis: {
        title: 'Month'
    },
    yaxis: {
        title: 'Air Quality'
    }
};
Plotly.newPlot('scatterChart', dataScatter, layoutScatter);

// Pie Chart
var dataPie = [{
    values: [100, 200, 300, 300,100], 
    labels: ['Invent', 'Lonsdale', 'NRF', 'Marconi','McNulty'], 
    type: 'pie'
}];
var layoutPie = {
    title: 'Building Population Distribution',
    height: 400,
    width: 500
};
Plotly.newPlot('pieChart', dataPie, layoutPie);

