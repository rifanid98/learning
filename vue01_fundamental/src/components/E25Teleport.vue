<template>
    <div>
        <!-- Teleport digunakan untuk merender component di luar
             dari target component defaultnya. 
             Misalkan saat ini component vue akan dirender di tag 
             div dengan id app.

             Dengan teleport, kita bisa merender component di luar
             tag div tersebut. -->
        <p>Teleport Component</p>
        <!-- <teleport to="#teleport">
            <p>ini juga bisa diteleport</p>
        </teleport> -->
    </div>
</template>

<script>
export default {
    name: 'E25Teleport',
    data() {
        return {

        }
    }
}
</script>