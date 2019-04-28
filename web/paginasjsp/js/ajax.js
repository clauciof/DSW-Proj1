var xmlHttp;

function apresentaDS() {
    var cidade = document.getElementById("cidade");
    var estado = document.getElementById("estado");
    var selCidade = cidade.options[cidade.selectedIndex].value; 
    var selEstado = estado.options[estado.selectedIndex].value;
    console.log(selCidade +"/" + selEstado);
    alert("Selecionado: " + selCidade +"/" + selEstado); 
}

function teatroSelecionado(str) {
    if (typeof XMLHttpRequest !== "undefined") {
        xmlHttp = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    if (xmlHttp === null) {
        alert("Browser does not support XMLHTTP Request");
        return;
    }

    var url = "buscaPromocaoPorTeatro";
    url += "?teatro=" + str;
   // xmlHttp.onreadystatechange = atualizaCidades;
    xmlHttp.open("GET", url, true);
    xmlHttp.send(null);
}

function cidadeSelecionada(str) {
    if (typeof XMLHttpRequest !== "undefined") {
        xmlHttp = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    if (xmlHttp === null) {
        alert("Browser does not support XMLHTTP Request");
        return;
    }

    var url = "buscaTeatroPorCidade";
    url += "?cidade=" + str;
   // xmlHttp.onreadystatechange = atualizaCidades;
    xmlHttp.open("GET", url, true);
    xmlHttp.send(null);
}

function atualizaCidades() {
    if (xmlHttp.readyState === 4 || xmlHttp.readyState === "complete") {
        document.getElementById("cidades").innerHTML = xmlHttp.responseText;
    }
}

