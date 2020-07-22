document.getElementById('create').addEventListener('change', function () {
    'use strict';
    var vis = document.querySelector('.vis'), create = document.getElementById(this.value);
    if (vis !== null) {
        vis.className = 'inv';
    }
    if (create !== null) {
        create.className = 'vis';
    }
});

document.getElementById('edit').addEventListener('change', function () {
    'use strict';
    var vis = document.querySelector('.visedit'), edit = document.getElementById(this.value);
    if (vis !== null) {
        vis.className = 'invedit';
    }
    if (edit !== null) {
        edit.className = 'visedit';
    }
});
