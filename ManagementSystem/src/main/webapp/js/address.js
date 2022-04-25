/**
 * 
 */
 $('a#add-more').cloneData({
        mainContainerId: 'main-container', // Main container Should be ID
        cloneContainer: 'container-item', // Which you want to clone
        removeButtonClass: 'remove-item', // Remove button for remove cloned HTML
        removeConfirm: true, // default true confirm before delete clone item
        removeConfirmMessage: 'Are you sure want to delete?', // confirm delete message
		excludeHTML:".exclude",
        //append: '<a href="javascript:void(0)" class="remove-item btn btn-sm btn-danger remove-social-media">Remove</a>', // Set extra HTML append to clone HTML
        minLimit: 1, // Default 1 set minimum clone HTML required
        maxLimit: 5, // Default unlimited or set maximum limit of clone HTML
		clearInputs:true,	
  		counterIndex: 0,
  		regexID: /^(.+?)([-\d-]{1,})(.+)$/i,
  		regexName: /(^.+?)([\[\d{1,}\]]{1,})(\[.+\]$)/i,
		// empty elements with emptySelector
		  emptySelector: ".empty",
		
		  // CSS class appended to the duplicated form fields
		  copyClass: "clone-div",
		
		  // HTML to attach at the end of each copy
		  append: '',
		
		  // custom template
		  template: null,
		  
		  // true = render/initialize one clone
		  defaultRender: true, 
		
		  // for select2 plugin
		  select2InitIds: [],
		
		  // for ckeditor plugin
		  ckeditorIds: [],
       	  defaultRender: 1,
		
        init: function () {
            console.info(':: Initialize Plugin ::');
        },
        beforeRender: function () {
            console.info(':: Before rendered callback called');
        },
        afterRender: function () {
            console.info(':: After rendered callback called');
            //$(".selectpicker").selectpicker('refresh');
        },
        afterRemove: function () {
            console.warn(':: After remove callback called');
        },
        beforeRemove: function () {
            console.warn(':: Before remove callback called');
        }

    });