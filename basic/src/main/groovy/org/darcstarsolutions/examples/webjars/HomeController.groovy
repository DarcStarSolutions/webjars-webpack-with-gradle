package org.darcstarsolutions.examples.webjars

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

/**
 * Created by mharris on 4/18/16.
 */

@Controller
class HomeController {

    @GetMapping("/")
    String index() {
        return "index"
    }

}
