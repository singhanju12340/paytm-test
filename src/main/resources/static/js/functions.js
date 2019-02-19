function addEnv(row) {
  var table = document.getElementById("myTable");
    var row1 = table.insertRow(row);
    var cell1 = row1.insertCell(0);
    var cell2 = row1.insertCell(1);
    var cell3 = row1.insertCell(2);
    var cell4 = row1.insertCell(3);
    var envname=document.createElement("input");
    envname.id = row+"_envtext";
    envname.type="text";
    envname.setAttribute("name",row+"_envtext");
    cell1.appendChild(envname);


    var ip=document.createElement("input");
    ip.id = row+"_text";
        ip.type="text";
        ip.setAttribute("name",row+"_text");
        //ip.value="IP value";

        cell2.appendChild(ip);

    //cell2.innerHTML = row;
    var edit=document.createElement("input");
        edit.id = row+"_edit";
        edit.setAttribute("name",row+"_edit");
            edit.type="button";
            edit.value="EDIT"
            cell3.appendChild(edit);

            var save=document.createElement("input");
                    save.id = row+"_save";
                    save.setAttribute("name",row+"_save");
                        save.type="submit";
                        save.value="SAVE"
                        //save.onClick="savedata(row)";
                        save.setAttribute('onClick', 'savedata('+row+')');
                        cell4.appendChild(save);
                        //window.location.reload();

}

function enableText(a)
    {
        document.getElementById(a+"_text").disabled = false;
        document.getElementById(a+"_text").removeAttribute("disabled");
        document.getElementById(a+"_envtext").disabled = false;
        document.getElementById(a+"_envtext").removeAttribute("disabled");

    }
    function savedata(aa)
        {
        var  env= document.getElementById(aa+"_envtext").value;
        var ip=document.getElementById(aa+"_text").value;
        if(ip=='' || env=='')
                {
                alert("Please enter environment and IP.")}
        }