app.controller("authority-ctrl" , function($scope ,$http,$location){
    

    $scope.roles =[] ;
    $scope.admins =[] ;
    $scope.authorities =[];


    $scope.initialize =function(){

        //load allroles
        $http.get("/rest/roles").then(resp => {
            $scope.roles = resp.data;
        })

        //load staff and director
        $http.get("/rest/director?admin=true").then(resp =>{
            $scope.admins = resp.data ;
        })

        //load authorities of staff and director
        $http.get("/rest/authorities?admin=true").then(resp => {
            $scope.authorities = resp.data ;
        }).catch(error =>{
            $location.path("/unauthorized");
        })
    }
    
    $scope.authority_of= function(acc, role){
        if($scope.authorities){
            return $scope.authorities.find(ur => ur.account.username == acc.username && ur.role.id==role.id);
        }
    }


    $scope.authority_changed =function(acc, role){
		var authority = $scope.authority_of(acc, role);
		if(authority){ //cap quyen => thu hoi quyen xoa
			$scope.revoke_authority(authority);
		}
		else{// chua duoc cap quyen => cap quyen them moi
			authority = {account: acc,role: role};
			$scope.grant_authority(authority);
			}
		}

        //them moi authority
        $scope.grant_authority = function(authority){
            $http.post(`/rest/authorities` , authority).then(resp =>{
                $scope.authorities.push(resp.data)
                alert("cấp quyền sử dụng thành công ");

            }).catch(error => {
                alert("cấp quyền sử dụng thất bại ");
                console.log("Error" ,error);
            })
        }

        //xoa authority
        $scope.revoke_authority = function(authority){
            $http.delete(`/rest/authorities/${authority.id}`).then(resp =>{

                var index = $scope.authorities.findIndex(a => a.id == authority.id)
                $scope.authorities.splice(index,1)
                alert("remove quyền sử dụng thành công ");

            }).catch(error => {
                alert("remove quyền sử dụng thất bại ");
                console.log("Error" ,error);
            })
        }
        $scope.initialize();
	 
    });


  