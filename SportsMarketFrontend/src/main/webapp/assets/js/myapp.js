$(function()
		{	
	switch(menu)
	{
	 
	case 'Contact':
	 $('#contact').addClass('active');
	 break;
	
	case 'Login':
	 $('#login').addClass('active');
	 break;
	
	case 'Register':
	 $('#register').addClass('active');
	break;
	
	case 'AllProducts':
	$('#products').addClass('active');
	break;
		
	default:
		if(menu=="Home") break;
	$('#products').addClass('active');
	$('#a_'+menu).addClass(	'active');
	break;	
	}
});