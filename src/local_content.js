function readTextFile(file)
{
    var rawFile = new XMLHttpRequest();
    rawFile.open("GET", file, false);
    rawFile.onreadystatechange = function ()
    {
        if(rawFile.readyState === 4)
        {
            if(rawFile.status === 200 || rawFile.status == 0)
            {
                var allText = rawFile.responseText;
                // This is where code (to compare token in text file with the entered token) must be written
            }
        }
    }
    rawFile.send(null);
}

readTextFile("file_path_must_be_entered_here")
