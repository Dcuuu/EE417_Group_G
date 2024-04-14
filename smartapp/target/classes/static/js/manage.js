document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('classroomForm');
    const classroomsTableBody = document.getElementById('classroomsTable').getElementsByTagName('tbody')[0];

    fetchClassrooms();

    form.addEventListener('submit', function(event) {
        event.preventDefault();
        const classroomId = form.classroomId.value;
        const name = form.name.value;
        const capacity = form.capacity.value;

        const classroom = { classroomId, name, capacity };
        if (classroomId) {
            updateClassroom(classroomId, classroom);
        } else {
            addClassroom(classroom);
        }
    });


   
    function addClassroom(classroom) {
        fetch('/classrooms/add-class', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(classroom)
        })
        .then(response => response.json())
        .then(() => {
            alert('New classroom added successfully!');
            resetForm();
            fetchClassrooms();  
        })
        .catch(error => {
            console.error('Failed to add classroom:', error);
            alert('Failed to add classroom.');
        });
    }


    function updateClassroom(classroomId, classroom) {
        fetch(`/classrooms/update-class/${classroomId}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(classroom)
        })
        .then(response => response.json())
        .then(() => {
            resetForm();
            fetchClassrooms();  
        });
    }


    window.deleteClassroom = function(classroomId) {
        if (confirm('Are you sure you want to delete this classroom?')) {
            fetch(`/classrooms/delete-class/${classroomId}`, {
                method: 'DELETE'
            })
            .then(() => {
                fetchClassrooms(); 
            });
        }
    }


function updateClassroom(classroomId, classroom) {
    fetch(`/classrooms/update-class/${classroomId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(classroom)
    })
    .then(response => {
        if (response.ok) {
            return response.json();
        } else {
            throw new Error('Failed to update classroom');
        }
    })
    .then(data => {
        alert('Classroom updated successfully!');
        resetForm();
        fetchClassrooms();
    })
    .catch(error => {
        console.error('Failed to update classroom:', error);
        alert('Failed to update classroom.');
    });
}


window.editClassroom = function(classroomId) {
    fetch(`/classrooms/${classroomId}`)  
    .then(response => {
        if (response.ok) {
            return response.json();
        } else {
            throw new Error('Failed to fetch classroom details');
        }
    })
    .then(data => {
        form.classroomId.value = data.classroomId;
        form.name.value = data.name;
        form.capacity.value = data.capacity;
    })
    .catch(error => {
        console.error('Failed to fetch classroom details:', error);
        alert('Failed to fetch classroom details.');
    });
}




    function fetchClassrooms() {
        fetch('/classrooms/get_all')
        .then(response => response.json())
        .then(data => {
            classroomsTableBody.innerHTML = ''; 
            data.forEach(classroom => {
                const row = classroomsTableBody.insertRow();
                row.innerHTML = `
                    <td>${classroom.classroomId}</td>
                    <td>${classroom.name}</td>
                    <td>${classroom.capacity}</td>
                    <td>
                        <button onclick="editClassroom(${classroom.classroomId})">Edit</button>
                        <button onclick="deleteClassroom(${classroom.classroomId})">Delete</button>
                    </td>
                `;
            });
        });
    }


    function resetForm() {
        form.reset();
        form.classroomId.value = '';
    }
});
