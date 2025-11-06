document.addEventListener('DOMContentLoaded', function() {
    const pantallaKarga = document.getElementById('kargapantaila');
    const progresoKarga = document.getElementById('kargaprozesua');
    
    let progresoa = 0;
    const iraupena = 3000; 
    const tartea = 50; 
    
    const gehikuntza = 100 / (iraupena / tartea);
    
    const eguneratuProgresoa = setInterval(function() {
        progresoa += gehikuntza;
        progresoKarga.value = progresoa;
        
        if (progresoa >= 100) {
            clearInterval(eguneratuProgresoa);
            
            setTimeout(function() {
                pantallaKarga.style.display = 'none';
                console.log('Karga amaitu da');
            }, 300);
        }
    }, tartea);
});