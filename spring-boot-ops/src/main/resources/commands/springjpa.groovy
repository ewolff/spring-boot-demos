package commands

import org.crsh.cli.*
import javax.persistence.*
import org.springframework.beans.factory.BeanFactory
import crash.commands.base.jpa

class springjpa extends jpa {

    @Usage("Open a JPA session")
    @Command
    Object open() {

        if (em != null) {
            throw new ScriptException("Already connected")
        }

        BeanFactory bf = context.attributes['spring.beanfactory']
        em = bf.getBean(EntityManager)

        "Using $em entity manager factory\n"
    }
}