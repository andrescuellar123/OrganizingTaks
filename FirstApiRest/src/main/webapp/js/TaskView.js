
class TaskView{
    
    constructor (task){
        this.task = task;
        this.onDeleteFinish=null;
    }

    deleteTask = ()=>{
            
            let xhr = new XMLHttpRequest();
            xhr.addEventListener('readystatechange', ()=>{
                if(xhr.readyState == 4){
                    var response = JSON.parse(xhr.responseText);
                    if(response.message == 'Operacion exitosa'){
                        if(this.onDeleteFinish != null){
                         this.onDeleteFinish();
                        }
                    }else{
                        alert('no se pudo eliminar la task');
                    }
                }
            });
            xhr.open('DELETE','http://localhost:8080/FirstApiRest/api/A00359221tasksManager/delete/'+this.task.id);
            xhr.send();
    }
    
    
    ascendTask=( )=>{
       
        let xhr = new XMLHttpRequest();
        xhr.addEventListener('readystatechange', ()=>{
            if(xhr.readyState == 4){
                var response = JSON.parse(xhr.responseText);
                if(response.message == 'Operacion exitosa'){
                    getAllDOING();
                    getAllTODO();
                    getAllDONE();
                }else{
                    alert('no se pudo eliminar la task' + response);
                }
            }
        });
        if(this.task.state === 'TODO'){
            this.task.state = "DOING";
            console.log(this.task.state+' jajajaj 2');
        }
        else if(this.task.state === 'DOING'){
            this.task.state = "DONE";
            console.log(this.task.state+' jajajaj 2');
        }
   xhr.open('PUT','http://localhost:8080/FirstApiRest/api/A00359221tasksManager/edit');
   xhr.setRequestHeader('Content-Type','application/json');
   xhr.send(JSON.stringify(this.task));      
    }

    descendTask=( )=>{
       
        let xhr = new XMLHttpRequest();
        xhr.addEventListener('readystatechange', ()=>{
            if(xhr.readyState == 4){
                var response = JSON.parse(xhr.responseText);
                if(response.message == 'Operacion exitosa'){
                    getAllDONE();
                    getAllDOING();
                    getAllTODO();
                    
                }else{
                    alert('no se pudo eliminar la task' + response);
                }
            }
        });
        if(this.task.state === 'DOING'){
            this.task.state = "TODO";
            console.log(this.task.state+' jajajaj 2');
        }
        else if(this.task.state === 'DONE'){
            this.task.state = "DOING";
            console.log(this.task.state+' jajajaj 2');
        }
   xhr.open('PUT','http://localhost:8080/FirstApiRest/api/A00359221tasksManager/edit');
   xhr.setRequestHeader('Content-Type','application/json');
   xhr.send(JSON.stringify(this.task));      
    }
    render =()=>{
        let component = document.createElement('div');
        component.id='task'+this.task.id;
        component.className = 'taskComponent';
        let nombre = document.createElement('p');
        let descripcion = document.createElement('p');
        let fecha = document.createElement('small');
        let deleteBtn = document.createElement('button'); 
        let ascendBtn = document.createElement('button'); 

        deleteBtn.innerHTML = 'X';
        deleteBtn.className = 'delBtn';
        ascendBtn.innerHTML = 'X';
        ascendBtn.className = 'ascendBtn';

        nombre.innerHTML = this.task.nombre;
        descripcion.innerHTML = this.task.descripcion;
        fecha.innerHTML = this.task.fecha;

        component.appendChild(nombre);
        component.appendChild(descripcion);
        component.appendChild(fecha);
        component.appendChild(deleteBtn);
        component.appendChild(ascendBtn);



        deleteBtn.addEventListener('click',this.deleteTask);
        ascendBtn.addEventListener('click',this.ascendTask);
        return component; 
    }


    render2 =()=>{
        let component = document.createElement('div');
        component.id='task'+this.task.id;
        component.className = 'taskComponent';


        let nombre = document.createElement('p');
        let descripcion = document.createElement('p');
        let fecha = document.createElement('small');
        let deleteBtn = document.createElement('button'); 
        let ascendBtn = document.createElement('button'); 
        let descendBtn = document.createElement('button'); 

        nombre.innerHTML = this.task.nombre;
        descripcion.innerHTML = this.task.descripcion;
        fecha.innerHTML = this.task.fecha;

        deleteBtn.innerHTML = 'X';
        deleteBtn.className = 'delBtn';
        ascendBtn.innerHTML = 'X';
        ascendBtn.className = 'ascendBtn';
        descendBtn.innerHTML = 'X';
        descendBtn.className = 'descendBtn';

        component.appendChild(nombre);
        component.appendChild(descripcion);
        component.appendChild(fecha);
        component.appendChild(deleteBtn);
        component.appendChild(ascendBtn);
        component.appendChild(descendBtn);

        deleteBtn.addEventListener('click',this.deleteTask);
        ascendBtn.addEventListener('click',this.ascendTask);
        descendBtn.addEventListener('click',this.descendTask);

        return component;
    }



    render3 =()=>{
        let component = document.createElement('div');
        component.id='task'+this.task.id;
        component.className = 'taskComponent';


        let nombre = document.createElement('p');
        let descripcion = document.createElement('p');
        let fecha = document.createElement('small');
        let deleteBtn = document.createElement('button'); 
        let descendBtn = document.createElement('button'); 

        nombre.innerHTML = this.task.nombre;
        descripcion.innerHTML = this.task.descripcion;
        fecha.innerHTML = this.task.fecha;

        deleteBtn.innerHTML = 'X';
        deleteBtn.className = 'delBtn';
        descendBtn.innerHTML = 'X';
        descendBtn.className = 'descendBtn';

        component.appendChild(nombre);
        component.appendChild(descripcion);
        component.appendChild(fecha);
        component.appendChild(deleteBtn);
        component.appendChild(descendBtn);

        deleteBtn.addEventListener('click',this.deleteTask);
        descendBtn.addEventListener('click',this.descendTask);

        return component;
    }
}