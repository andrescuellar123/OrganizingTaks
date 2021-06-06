const nombre = document.getElementById('nombre');
const descripcion = document.getElementById('descripcion');
const regBtn = document.getElementById('regBtn');
const taskContainer = document.getElementById('taskContainer');
const taskContainerDoing = document.getElementById('taskContainerDoing');
const taskContainerDone = document.getElementById('taskContainerDone');

const registrarse =()=>{
    let taskObj ={
        id:0,
        nombre:nombre.value,
        descripcion:descripcion.value
    };

    console.log(JSON.stringify(taskObj));
    //POST
    let xhr = new XMLHttpRequest();

    //RESPONSE
    xhr.addEventListener('readystatechange' , ()=>{
        if(xhr.readyState == 4){
            console.log(xhr.responseText);
            getAllTODO();
        }
         
    });

    xhr.open('POST','http://localhost:8080/FirstApiRest/api/A00359221tasksManager/create');
    xhr.setRequestHeader('Content-Type','application/json');
    xhr.send(JSON.stringify(taskObj));
}

regBtn.addEventListener('click', registrarse);

const getAllTask =() =>{
     
    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange' , ()=>{
        if(xhr.readyState ==4){
            let json = xhr.responseText;
            let response = JSON.parse(json);
            console.log(response);
            taskContainer.innerHTML = '';
            for(let i =0;i<response.length ; i++){
                let taskDTO = response[i];
                let view = new TaskView(taskDTO);
                view.onDeleteFinish = ()=>{
                    taskContainer.removeChild(document.getElementById('task'+taskDTO.id));
                };
                taskContainer.appendChild(view.render());
            }
        }
    });
    xhr.open('GET','http://localhost:8080/FirstApiRest/api/A00359221tasksManager/all');
    xhr.send();
};


const getAllTODO =() =>{
     
    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange' , ()=>{
        if(xhr.readyState ==4){
            let json = xhr.responseText;
            let response = JSON.parse(json);
            console.log(response);
            taskContainer.innerHTML = '';
            for(let i =0;i<response.length ; i++){
                let taskDTO = response[i];
                let view = new TaskView(taskDTO);
                view.onDeleteFinish = ()=>{
                    taskContainer.removeChild(document.getElementById('task'+taskDTO.id));
                };
                taskContainer.appendChild(view.render());
            }
        }
    });
    xhr.open('GET','http://localhost:8080/FirstApiRest/api/A00359221tasksManager/TODO');
    xhr.send();
};


const getAllDOING =() =>{
     
    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange' , ()=>{
        if(xhr.readyState ==4){
            let json = xhr.responseText;
            let response = JSON.parse(json);
            console.log(response);
            taskContainerDoing.innerHTML = '';
            for(let i =0;i<response.length ; i++){
                let taskDTO = response[i];
                let view = new TaskView(taskDTO);
                view.onDeleteFinish = ()=>{
                    taskContainerDoing.removeChild(document.getElementById('task'+taskDTO.id));
                };
                taskContainerDoing.appendChild(view.render2());
            }
        }
    });
    xhr.open('GET','http://localhost:8080/FirstApiRest/api/A00359221tasksManager/DOING');
    xhr.send();
};


const getAllDONE =() =>{
     
    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange' , ()=>{
        if(xhr.readyState ==4){
            let json = xhr.responseText;
            let response = JSON.parse(json);
            console.log(response);
            taskContainerDone.innerHTML = '';
            for(let i =0;i<response.length ; i++){
                let taskDTO = response[i];
                let view = new TaskView(taskDTO);
                view.onDeleteFinish = ()=>{
                    taskContainerDone.removeChild(document.getElementById('task'+taskDTO.id));
                };
                taskContainerDone.appendChild(view.render3());
            }
        }
    });
    xhr.open('GET','http://localhost:8080/FirstApiRest/api/A00359221tasksManager/DONE');
    xhr.send();
};

getAllTODO();
getAllDOING();
getAllDONE();