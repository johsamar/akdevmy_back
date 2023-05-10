[33mcommit 30ec4d581feed329e35ba7a4f7353cb198efb7c0[m[33m ([m[1;36mHEAD -> [m[1;32mmodules[m[33m)[m
Author: Eider22 <eidercardona22@gmail.com>
Date:   Tue May 9 18:26:18 2023 -0500

    Manage classes
    - The controller and service are created and methods are declarated  to add classes to a module
    - Missing implements the methods

[33mcommit 299e1e2c2e322843173ec0dc0cc21814532433c6[m[33m ([m[1;31morigin/modules[m[33m)[m
Author: Eider22 <eidercardona22@gmail.com>
Date:   Tue May 9 15:46:46 2023 -0500

    Config CORS to ModuleController

[33mcommit 764385e6c438c688e2bcc4dd58ad6c913e345efc[m
Author: Eider22 <eidercardona22@gmail.com>
Date:   Tue May 9 15:36:49 2023 -0500

    Add article and audio atributes to Class model

[33mcommit b5f1f0daaeae8bb2cc50a9b1a72cbe38f24d9848[m[33m ([m[1;31morigin/main[m[33m, [m[1;32mmain[m[33m)[m
Merge: 2370f65 ed3078c
Author: GioRestrepo <87251739+GioRestrepo@users.noreply.github.com>
Date:   Fri May 5 19:23:03 2023 -0500

    Merge pull request #6 from johsamar/dev
    
    Dev

[33mcommit ed3078c364eada73a8218ff2ca0c468d1f5403e9[m[33m ([m[1;31morigin/dev[m[33m)[m
Merge: 65c4d8e 868117b
Author: GioRestrepo <87251739+GioRestrepo@users.noreply.github.com>
Date:   Fri May 5 13:51:47 2023 -0500

    Merge pull request #5 from johsamar/dev-giovanny-r
    
    feat: added course controller

[33mcommit 868117b712e631d2bd6497f155d93186850b5951[m[33m ([m[1;31morigin/dev-giovanny-r[m[33m)[m
Merge: 2e44857 65c4d8e
Author: GioRestrepo <gierestrepove@unal.edu.co>
Date:   Fri May 5 13:47:52 2023 -0500

    Merge branch 'dev' of https://github.com/johsamar/akdevmy_back into dev-giovanny-r

[33mcommit 65c4d8ec3cdbb0955f268f1190142333b202d218[m
Merge: 0cd624a 48437e0
Author: GioRestrepo <87251739+GioRestrepo@users.noreply.github.com>
Date:   Fri May 5 13:44:05 2023 -0500

    Merge pull request #3 from johsamar/cusResAndExc
    
    Create custom response and custom Exception

[33mcommit 0cd624a2ddba720117c45f3170499eefe3385278[m
Merge: 9dd5472 dd6518f
Author: GioRestrepo <87251739+GioRestrepo@users.noreply.github.com>
Date:   Fri May 5 13:41:01 2023 -0500

    Merge pull request #2 from johsamar/modules
    
    Functionality to create, get  and findById Modules

[33mcommit 2e44857a37022049b1103cfafe3d2880bf8e8cbf[m
Author: GioRestrepo <gierestrepove@unal.edu.co>
Date:   Fri May 5 13:37:53 2023 -0500

    feat: add CORS

[33mcommit fac962e6e9b7ee066661a5145f75ea97babd9be9[m
Author: GioRestrepo <gierestrepove@unal.edu.co>
Date:   Fri May 5 13:31:54 2023 -0500

    feat: add Dockerfile

[33mcommit 7fd543caf93f86df819e48694961f56e5a76f31e[m
Author: GioRestrepo <gierestrepove@unal.edu.co>
Date:   Wed May 3 12:46:52 2023 -0500

    feat: added course controller

[33mcommit dd6518fde5d546e725facb79b34bea9cd236ee8c[m
Author: Eider22 <eidercardona22@gmail.com>
Date:   Mon May 1 17:18:46 2023 -0500

    The signature of the module's findById method is placed in the controller layer contract.

[33mcommit 44e9d6e41c34c0f167c803e0d6cd84d2bb44a021[m
Author: Eider22 <eidercardona22@gmail.com>
Date:   Mon May 1 16:56:42 2023 -0500

    Functionality to module findById
    - The functionality to module find by id is created
    - It was not possible to catch the IllegalArgumentException error,
      thrown by ReactiveMongoRespository when passing the null argument to
      .findById(null). It was not possible to catch it in the onErrorResume
      of findById in ModuleSerice.

[33mcommit 6845ea4ad566b037636b4be7cd62746817d6a14c[m
Author: Eider22 <eidercardona22@gmail.com>
Date:   Mon May 1 12:00:39 2023 -0500

    Remove unnecessary import and format code

[33mcommit 2576311e57a9a98abbd3f861bcac080423bbf8dc[m
Author: Eider22 <eidercardona22@gmail.com>
Date:   Mon May 1 11:19:48 2023 -0500

    Create full basic get modules functionality
    - The use to custom exception  is corrected in create new module
      funcionality and in get all modules fonctionality
    - Commentaries were added for the use of custom exceptions

[33mcommit 28e2ee4e0d4e332ef3201915faa180bb9a56c7ef[m
Author: Eider22 <eidercardona22@gmail.com>
Date:   Mon May 1 10:02:12 2023 -0500

    Create functionality basic to get all modules

[33mcommit db370401d01e810af28aa29c63f6ba27a0ef849b[m
Author: Eider22 <eidercardona22@gmail.com>
Date:   Mon May 1 08:03:39 2023 -0500

    Correction to customResponse

[33mcommit 48437e01321302578ab0e3c414817051643dd8ce[m[33m ([m[1;31morigin/cusResAndExc[m[33m, [m[1;32mcusResAndExc[m[33m)[m
Author: Eider22 <eidercardona22@gmail.com>
Date:   Mon May 1 07:59:03 2023 -0500

    Correction to CustomeResponse

[33mcommit cf03a8e2fb449ded8dcbcfe3ba97382794533d83[m
Author: Eider22 <eidercardona22@gmail.com>
Date:   Mon May 1 07:53:07 2023 -0500

    Add statusCode to customeException

[33mcommit 84d875b9d223a8caa4e38a0d014517bc1fe66aa2[m
Author: Eider22 <eidercardona22@gmail.com>
Date:   Mon May 1 07:51:48 2023 -0500

    Add statusCode to customException

[33mcommit 0b3813e4975b62dfe06c5f62aecf2c88fcc4dc8d[m
Author: Eider22 <eidercardona22@gmail.com>
Date:   Sun Apr 30 19:40:54 2023 -0500

    Correction to modules collection name

[33mcommit 07a39693ee9661c63a01c30f80f0d66c08d8f5af[m
Author: Eider22 <eidercardona22@gmail.com>
Date:   Sun Apr 30 19:26:24 2023 -0500

    Delete unnecessary method signature in IModuleReactiveRepository

[33mcommit 1d20b350d6080cb561508f0683ac1390b125a4de[m
Author: Eider22 <eidercardona22@gmail.com>
Date:   Sun Apr 30 19:10:30 2023 -0500

    Create custom response and custom Exception

[33mcommit 16557ff4fc813a79e6012cd1f709f557dd26de08[m[33m ([m[1;32mcustoms[m[33m)[m
Author: Eider22 <eidercardona22@gmail.com>
Date:   Sun Apr 30 19:01:56 2023 -0500

    Eliminate unnecessary validation

[33mcommit b9651034873696b6d5e5015950272e9fb695d73a[m
Merge: 9c9e0cd 9dd5472
Author: Eider22 <eidercardona22@gmail.com>
Date:   Sun Apr 30 18:23:39 2023 -0500

    Solved conflicts

[33mcommit 9c9e0cd2fcf8148c6d261e52e0ceacd8547ba47f[m
Author: Eider22 <eidercardona22@gmail.com>
Date:   Sun Apr 30 18:17:22 2023 -0500

    Functionality for creating a module
    - Functionality is made to create a module, including controller layer,
      service layer and repository layer.
    - It works with ReactiveMongoRepository
    - A custom response is created
    - A custom exception is created

[33mcommit 9dd5472927e5dddf1fc17baea411b6adfcfa687e[m[33m ([m[1;32mdev[m[33m)[m
Merge: 2370f65 840a628
Author: GioRestrepo <87251739+GioRestrepo@users.noreply.github.com>
Date:   Sun Apr 30 16:32:16 2023 -0500

    Merge pull request #1 from johsamar/dev-giovanny-r
    
    feat: mongo atlas url and database name

[33mcommit 840a628a0fd4f8bca9e3483e27bd39c599258d95[m
Author: GioRestrepo <gierestrepove@unal.edu.co>
Date:   Sun Apr 30 16:28:55 2023 -0500

    feat: mongo atlas url and database name

[33mcommit 3c46e38e3dadd5678ba2fd399d5d433f0967e105[m
Author: Eider22 <eidercardona22@gmail.com>
Date:   Sun Apr 30 13:46:56 2023 -0500

    Basic functionality create module

[33mcommit 2370f6568b6cec01d3f1f00eae8b8841c877fb36[m
Author: Eider22 <eidercardona22@gmail.com>
Date:   Sat Apr 29 09:56:48 2023 -0500

    change models folder ubication

[33mcommit 875356bf15bdf7c7deeefcf0af752199c2320b75[m
Author: Eider22 <eidercardona22@gmail.com>
Date:   Sat Apr 29 09:53:30 2023 -0500

    Create models folder

[33mcommit 4d20fedf279052e60ed1f9ee630e8b82fbb24846[m
Author: Eider22 <eidercardona22@gmail.com>
Date:   Sat Apr 29 08:56:35 2023 -0500

    Initial structure folders is created

[33mcommit 53d16b5d05bc719d21c22a0b076963da61c6e6e6[m
Author: Eider22 <eidercardona22@gmail.com>
Date:   Sat Apr 29 08:31:33 2023 -0500

    Configure server port and context path

[33mcommit 14d81c7af44541cfcd66d6e197d5ab292f77671f[m
Author: Eider22 <eidercardona22@gmail.com>
Date:   Sat Apr 29 08:29:24 2023 -0500

    The initial project with the initial required dependencies is created
