app.controller("account-ctrl" , function($scope ,$http){

    $scope.users =[];
    // $scope.cates =[];
    $scope.form = {
      
            photo : 'user.png'
           
    };
    $scope.authorities =[];

    $scope.initialize =function(){

       

        //  //load account
        // $http.get("/rest/accounts").then(resp =>{
        //     $scope.items = resp.data;
        //     // $scope.items.forEach(item => {
        //     //     item.createDate =new Date(item.createDate)
        //     // })

        // });

        //load custommer
        $http.get("/rest/accounts?user=true").then(resp =>{
            $scope.users = resp.data ;
        })


        // $http.get("/rest/roles").then(resp => {
        //     $scope.roles = resp.data;
        // })

          //load cust
          $http.get("/rest/cust?user=true").then(resp => {
            $scope.authorities = resp.data ;
        })
       
        
    }

    $scope.authority_of= function(acc, role){
        if($scope.authorities){
            return $scope.authorities.find(ur => ur.account.username == acc.username && ur.role.id==role.id);
        }
    }

  

          //them moi authority
    $scope.grant_authority = function(authority){
        var authority = $scope.authority_of(acc, role);
        authority = {account: acc,role: role};
        $http.post(`/rest/authorities` , authority).then(resp =>{
            $scope.authorities.push(resp.data)   

        }).catch(error => {
            
            console.log("Error" ,error);
        })
    }



    // khoi dau
    $scope.initialize();

    //xoa form 
    $scope.reset = function(){

        $scope.form = {
            
            photo : 'user.png'
            
        };
    }

    //hien thi len form 
    $scope.edit = function(user){
        $scope.form= angular.copy(user);
        $(".nav-tabs a:eq(0)" ).tab('show')
    }

    //them account
    $scope.create= function(){ 
        var user = angular.copy($scope.form);
        
        $http.post(`/rest/accounts` , user ).then(resp =>{
         
            $scope.reset();
            
            alert("Them Moi SP Thanh Cong")
            

        }).catch(error => {
            alert("Error create sp");
            console.log("Error",error);
        }); 
    }

  

    //cap nhat sp 
    $scope.update = function(){
        var user = angular.copy($scope.form);
        
        $http.put(`/rest/accounts/${user.username}` , user ).then(resp =>{
            var index = $scope.users.findIndex(p => p.username == user.username);
           
            $scope.users[index] = user;
            $scope.reset();
            alert("Cap Nhat Thanh Cong")

        }).catch(error => {
            alert("Error update ");
            console.log("Error",error);
        }); 
    }


    //xoas san pham 
    $scope.delete = function(user){
        
        
        $http.delete(`/rest/accounts/${user.username}`  ).then(resp =>{
            var index = $scope.users.findIndex(p => p.username == user.username);
           
            $scope.users.splice(index,1  )
            $scope.reset();
            alert("Xoa  Sp Thanh Cong")

        }).catch(error => {
            alert("Error delete sp");
            console.log("Error",error);
        }); 
    }

    //upload hinh
    $scope.imageChange = function(files){
        var data = new FormData();
        data.append('file' ,files[0]);
        $http.post('/rest/upload/images' , data ,{
            transformRequest : angular.identity,
            headers: {'Content-Type' : undefined}

        }).then(resp =>{
            $scope.form.photo = resp.data.name;

        }).catch(error => {
            alert("Error upload image");
            console.log("Error",error);
        })
    }

    // phan trang
    $scope.pager ={
        page : 0,
        size : 10 ,
        get users(){

            var start = this.page * this.size;
         return   $scope.users.slice(start , start + this.size)
        },
        get count(){
            return Math.ceil(1.0 * $scope.users.length / this.size)
        },
        first(){
           this.page = 0;
        },

        prev(){
            this.page--;
            if(this.page < 0){
                this.last();
            }
        },
        next(){
            this.page++;
            if(this.page >= this.count){
                this.first();
            }
        },
        last(){
            this.page = this.count -1
            
        }


    }




});