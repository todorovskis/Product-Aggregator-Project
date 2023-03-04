//show remove button
function showRemoveButton(){
    let remove_btn = document.getElementById("remove");
    let add_btn = document.getElementById("add");
    if(remove_btn.style.display === "none"){
        remove_btn.style.display = "block";
        add_btn.style.display = "none";
    }
    else{
        remove_btn.style.display = "none";
        add_btn.style.display = "block";
    }
}

function showAddButton(){
    let add_btn = document.getElementById("add");
    let remove_btn = document.getElementById("remove");
    if(add_btn.style.display === "none"){
        add_btn.style.display = "block";
        remove_btn.style.display = "none";
    }
    else{
        add_btn.style.display = "none";
        remove_btn.style.display = "block";
    }
}