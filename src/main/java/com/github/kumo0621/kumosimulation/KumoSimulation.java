package com.github.kumo0621.kumosimulation;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Team;
import org.bukkit.util.EulerAngle;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public final class KumoSimulation extends JavaPlugin implements org.bukkit.event.Listener {
    Map<Team, Agent> map = new HashMap<>();
    Map<Team, Agent> map2 = new HashMap<>();
    Map<Team, Agent> map3 = new HashMap<>();
    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
        new BukkitRunnable() {
            int time = 0;
            int time2 = 0;
            int time3 = 0;

            @Override

            public void run() {
                //ループ何かやりたいときはここに書き込む
                double angle = Math.sin(Math.toRadians(time));
                double angle2 = Math.sin(Math.toRadians(time2));
                double angle3 = Math.sin(Math.toRadians(time3));


                for (Agent agent : map.values()) {
                    agent.armorStand.setLeftLegPose(makeAngle(angle * 33f, 0f, 0f));
                    agent.armorStand.setRightLegPose(makeAngle(angle * -33, 0f, 0f));
                    agent.armorStand.setLeftArmPose(makeAngle(angle * -26, 0f, 0f));
                    agent.armorStand.setRightArmPose(makeAngle(angle * 26f, 0f, 0f));
                }
                for (Agent agent2 : map2.values()) {
                    agent2.armorStand2.setLeftLegPose(makeAngle(angle2 * 33f, 0f, 0f));
                    agent2.armorStand2.setRightLegPose(makeAngle(angle2 * -33, 0f, 0f));
                    agent2.armorStand2.setLeftArmPose(makeAngle(angle2 * -26, 0f, 0f));
                    agent2.armorStand2.setRightArmPose(makeAngle(angle2 * 26f, 0f, 0f));
                }
                for (Agent agent3 : map3.values()) {
                    agent3.armorStand3.setLeftLegPose(makeAngle(angle3 * 33f, 0f, 0f));
                    agent3.armorStand3.setRightLegPose(makeAngle(angle3 * -33, 0f, 0f));
                    agent3.armorStand3.setLeftArmPose(makeAngle(angle3 * -26, 0f, 0f));
                    agent3.armorStand3.setRightArmPose(makeAngle(angle3 * 26f, 0f, 0f));
                }
                time += 10;
                time2 += 10;
                time3 += 10;
            }
        }.runTaskTimer(this, 0L, 0L);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    int set = 0;
    int haiti=0;

    @EventHandler
    public void RightClick(PlayerInteractAtEntityEvent event) {
        Player player = event.getPlayer();
        if (event.getRightClicked().getScoreboardTags().contains("1")) {
            player.sendMessage("選択肢1を選択しました。");
            set = 1;
        } else if (event.getRightClicked().getScoreboardTags().contains("2")) {
            player.sendMessage("選択肢2を選択しました。");
            set = 2;
        } else if (event.getRightClicked().getScoreboardTags().contains("3")) {
            player.sendMessage("選択肢3を選択しました。");
            set = 3;
        } else if (event.getRightClicked().getScoreboardTags().contains("0")) {
            player.sendMessage("選択肢をリセットしました。");
            set = 0;
        }
    }

    int number = 0;

    @EventHandler
    public void ClickItem(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_AIR) {
            ItemStack itemStack = player.getInventory().getItemInMainHand();
            if (itemStack.getType() == Material.STICK) ;
            if (0 <= set && set <= 3) {
                number++;
            }
            if (number == 1) {
                player.sendTitle(ChatColor.RED + "くもと恋愛シュミュレーション", "企画,コマンド:くも 校閲:なっしー 絵:二重顎", 10, 40, 10);
                Bukkit.broadcastMessage("物語はすべてフィクションです。");
            } else if (number == 2) {
                Bukkit.broadcastMessage("私は22歳の大学四年生。");
            } else if (number == 3) {
                Bukkit.broadcastMessage("12月になって就職先も決まり、あとは卒業まで大学生活を満喫するのみ！");
            } else if (number == 4) {
                Bukkit.broadcastMessage("そんな私は彼氏が欲しくてマッチングアプリ、kunderを初めてみました。");
            } else if (number == 5) {
                Bukkit.broadcastMessage("そしたら、くもさんという方とマッチングしたんです！");
            } else if (number == 6) {
                Bukkit.broadcastMessage("くもさんとは趣味も合うし歳も近かったので、勇気を出してデートのお約束をしました！");
            } else if (number == 7) {
                Bukkit.broadcastMessage("会ったこともない人とデートするなんて緊張しますが、上手くいくといいな！");
            } else if (number == 8) {
                Bukkit.broadcastMessage("------デート当日----------");
            } else if (number == 9) {
                Bukkit.broadcastMessage("彼女ちゃん「くもさんまだかなー」");
            } else if (number == 10) {
                Bukkit.broadcastMessage("？？？「彼女ちゃーん」");
            } else if (number == 11) {
                Bukkit.broadcastMessage("彼女ちゃん「もしかして、くもさんですか？」");
            } else if (number == 12) {
                Bukkit.broadcastMessage("くも「はい。そうです！」");
            } else if (number == 13) {
                Bukkit.broadcastMessage("くも「ちょっとデートの下見をしていたら遅くなってしまって…。一時間前にはついていたんですが…」");
            } else if (number == 14) {
                Bukkit.broadcastMessage("--------選択肢---------");
                Bukkit.broadcastMessage("1、彼女ちゃん「そうだったんですね。私のためにそこまでしてくれるなんて嬉しい！」");
                Bukkit.broadcastMessage("2、彼女ちゃん「あ、そうなんですね」");
                Bukkit.broadcastMessage("3、彼女ちゃん「え…きも」");

                Collection<? extends Player> onlinePlayers = Bukkit.getOnlinePlayers();
                map.clear();
                for (Player onlinePlayer : onlinePlayers) {
                    Location location = onlinePlayer.getLocation();
                    Location location2 = onlinePlayer.getLocation();
                    Location location3 = onlinePlayer.getLocation();
                    Team team = onlinePlayer.getScoreboard().getEntryTeam(onlinePlayer.getName());
                    Team team2 = onlinePlayer.getScoreboard().getEntryTeam(onlinePlayer.getName());
                    Team team3 = onlinePlayer.getScoreboard().getEntryTeam(onlinePlayer.getName());
                    if (team != null) {
                        if (!map.containsKey(team)&&haiti==0) {
                            haiti++;
                            @NotNull ArmorStand entity = location.getWorld().spawn(location, ArmorStand.class);
                            entity.setGravity(false);
                            entity.setSmall(true);
                            entity.setArms(true);
                            entity.addScoreboardTag("1");
                            entity.setCustomNameVisible(true);
                            entity.setCustomName("選択肢1");
                            map.put(team, new Agent(entity));
                           
                            Agent agent = map.get(team);
                            Location loc = agent.armorStand.getLocation();
                            moveFrontLocation(loc, 90);
                            loc.setY(loc.getY() + 2);
                            adjustPosition(location);
                            agent.armorStand.teleport(loc);
                            //
                            @NotNull ArmorStand entity2 = location2.getWorld().spawn(location2, ArmorStand.class);
                            entity2.setGravity(false);
                            entity2.setSmall(true);
                            entity2.setArms(true);
                            entity2.addScoreboardTag("2");
                            entity2.setCustomNameVisible(true);
                            entity2.setCustomName("選択肢2");
                            map2.put(team2, new Agent(entity2));
                          
                            Agent agent2 = map2.get(team);
                            Location loc2 = agent2.armorStand2.getLocation();
                            moveFrontLocation(loc2, 90);
                            loc2.setY(loc2.getY() + 1);
                            loc2.setX(loc2.getX() - 1);
                            adjustPosition(location2);
                            agent2.armorStand2.teleport(loc2);
                            //
                            @NotNull ArmorStand entity3 = location3.getWorld().spawn(location3, ArmorStand.class);
                            entity3.setGravity(false);
                            entity3.setSmall(true);
                            entity3.setArms(true);
                            entity3.addScoreboardTag("3");
                            entity3.setCustomNameVisible(true);
                            entity3.setCustomName("選択肢3");
                            map3.put(team3, new Agent(entity3));
                            
                            Agent agent3 = map3.get(team);
                            Location loc3 = agent3.armorStand3.getLocation();
                            moveFrontLocation(loc3, 90);
                            loc3.setY(loc3.getY() + 1);
                            loc3.setX(loc3.getX() + 1);
                            adjustPosition(location3);
                            agent3.armorStand3.teleport(loc3);
                            set = -99;
                            number++;
                        }
                    } else {
                        player.sendMessage("チームが存在しません");
                    }
                }
            } else if (0 <= number && number <= 20 && set == 1) {
                switch (number) {
                    case 16:
                        haiti=0;
                        for (Agent agent : map.values()){
                            agent.armorStand.remove();

                    }
                        for (Agent agent2 : map2.values()){
                            agent2.armorStand2.remove();

                        }
                        for (Agent agent3 : map3.values()){
                            agent3.armorStand3.remove();

                        }
                        Bukkit.broadcastMessage("くも「でも、ちょっと変だよね…」");
                        break;
                    case 17:
                        Bukkit.broadcastMessage("彼女ちゃん「ううん。そんなことないよ！」");
                        break;
                    case 18:
                        Bukkit.broadcastMessage("彼女ちゃん「それよりほら、デート早く行こ」");
                        number = 20;
                        break;
                }
            } else if (0 <= number && number <= 20 && set == 2) {
                switch (number) {
                    case 16:
                        haiti=0;
                        for (Agent agent : map.values()){
                            agent.armorStand.remove();

                        }
                        for (Agent agent2 : map2.values()){
                            agent2.armorStand2.remove();

                        }
                        for (Agent agent3 : map3.values()){
                            agent3.armorStand3.remove();

                        }
                        Bukkit.broadcastMessage("くも「うん。でも、ちょっと変だよね…」");
                        break;
                    case 17:
                        Bukkit.broadcastMessage("彼女ちゃん「なんというか、ちょっと気合い入りすぎかも」");
                        break;
                    case 18:
                        Bukkit.broadcastMessage("くも「気持ち悪いかな？」");
                        break;
                    case 19:
                        Bukkit.broadcastMessage("彼女ちゃん「気持ち悪いというか、異常ですね」");
                        break;
                    case 20:
                        Bukkit.broadcastMessage("くも「そっか」");
                        break;
                }
            } else if (0 <= number && number <= 20 && set == 3) {
                switch (number) {
                    case 16:
                        haiti=0;
                        for (Agent agent : map.values()){
                            agent.armorStand.remove();

                        }
                        for (Agent agent2 : map2.values()){
                            agent2.armorStand2.remove();

                        }
                        for (Agent agent3 : map3.values()){
                            agent3.armorStand3.remove();

                        }
                        Bukkit.broadcastMessage("くも「そっか。キモいよね」");
                        break;
                    case 17:
                        Bukkit.broadcastMessage("彼女ちゃん「うん」");
                        break;
                    case 18:
                        Bukkit.broadcastMessage("くも「帰る？」");
                        break;
                    case 19:
                        Bukkit.broadcastMessage("彼女ちゃん「いや。大丈夫」");
                        break;
                    case 20:
                        Bukkit.broadcastMessage("くも「そっか」");
                        break;
                }
            } else if (number == 21) {
                Bukkit.broadcastMessage("くも「それじゃあ行こっか」");
            } else if (number == 22) {
                Bukkit.broadcastMessage("くも「ボウリングかカラオケに行こうと思ってるんだけど」");
            } else if (number == 23) {
                Bukkit.broadcastMessage("くも「どっちがいい？」");
            } else if (number == 24) {
                Bukkit.broadcastMessage("--------選択肢---------");
                Bukkit.broadcastMessage("1、ボウリング");
                Bukkit.broadcastMessage("2、カラオケ");
                Collection<? extends Player> onlinePlayers = Bukkit.getOnlinePlayers();
                map.clear();
                for (Player onlinePlayer : onlinePlayers) {
                    Location location = onlinePlayer.getLocation();
                    Location location2 = onlinePlayer.getLocation();
                    Location location3 = onlinePlayer.getLocation();
                    Team team = onlinePlayer.getScoreboard().getEntryTeam(onlinePlayer.getName());
                    Team team2 = onlinePlayer.getScoreboard().getEntryTeam(onlinePlayer.getName());
                    if (team != null) {
                        if (!map.containsKey(team)&&haiti==0) {
                            haiti++;
                            @NotNull ArmorStand entity = location.getWorld().spawn(location, ArmorStand.class);
                            entity.setGravity(false);
                            entity.setSmall(true);
                            entity.setArms(true);
                            entity.addScoreboardTag("1");
                            entity.setCustomNameVisible(true);
                            entity.setCustomName("選択肢1");
                            map.put(team, new Agent(entity));
                           
                            Agent agent = map.get(team);
                            Location loc = agent.armorStand.getLocation();
                            moveFrontLocation(loc, 90);
                            loc.setY(loc.getY() + 2);
                            adjustPosition(location);
                            agent.armorStand.teleport(loc);
                            //
                            @NotNull ArmorStand entity2 = location2.getWorld().spawn(location2, ArmorStand.class);
                            entity2.setGravity(false);
                            entity2.setSmall(true);
                            entity2.setArms(true);
                            entity2.addScoreboardTag("2");
                            entity2.setCustomNameVisible(true);
                            entity2.setCustomName("選択肢2");
                            map2.put(team2, new Agent(entity2));
                          
                            Agent agent2 = map2.get(team);
                            Location loc2 = agent2.armorStand2.getLocation();
                            moveFrontLocation(loc2, 90);
                            loc2.setY(loc2.getY() + 1);
                            loc2.setX(loc2.getX() - 1);
                            adjustPosition(location2);
                            agent2.armorStand2.teleport(loc2);
                            number++;
                            //
                        }
                    } else {
                        player.sendMessage("チームが存在しません");
                    }
                }
                set = -99;
            } else if (26 <= number && number <= 49 && set == 1) {
                switch (number) {
                    case 26:
                        haiti=0;
                        for (Agent agent : map.values()){
                            agent.armorStand.remove();

                        }
                        for (Agent agent2 : map2.values()){
                            agent2.armorStand2.remove();

                        }
                        Bukkit.broadcastMessage("彼女ちゃん「それじゃあ…ボウリングがいいかな」");
                        break;
                    case 27:
                        Bukkit.broadcastMessage("くも「わかった！！」");
                        break;
                    case 28:
                        Bukkit.broadcastMessage("こうして私はくもさんに連れられ、池袋のラウンドkunへと来ました。");
                        break;
                    case 29:
                        Bukkit.broadcastMessage("くも「ここはよく来るんだ。元カノとのデートでもよく来てたし」");
                        break;
                    case 30:
                        Bukkit.broadcastMessage("彼女ちゃん「そうなんだ…。他にも彼女いたんだね」");
                        break;
                    case 31:
                        Bukkit.broadcastMessage("くも「うん。30人はいたよ」");
                        break;
                    case 32:
                        Bukkit.broadcastMessage("彼女ちゃん「30人!?」");
                        break;
                    case 33:
                        Bukkit.broadcastMessage("くも「うん」");
                        break;
                    case 34:
                        Bukkit.broadcastMessage("くも「それじゃあ受付してくるね～」");
                        break;
                    case 35:
                        Bukkit.broadcastMessage("彼女ちゃん「あ、じゃあ私ここで待ってるね」");
                        break;
                    case 36:
                        Bukkit.broadcastMessage("（もしかしたらくもさんってやばい人なのかも…。でも良いところもきっとあるはず！）");
                        break;
                    case 37:
                        Bukkit.broadcastMessage("・・・・・・5分後・・・・・・・");
                        break;
                    case 38:
                        Bukkit.broadcastMessage("くも「受け付け終わったよ」");
                        break;
                    case 39:
                        Bukkit.broadcastMessage("彼女ちゃん「私、ボウリングはじめてだから下手かも」");
                        break;
                    case 40:
                        Bukkit.broadcastMessage("くも「そうなんだ。じゃあ、僕が手取り足取り教えるね」");
                        break;
                    case 41:
                        Bukkit.broadcastMessage("彼女ちゃん「うん…」");
                        break;
                    case 42:
                        Bukkit.broadcastMessage("・・・・・・・30分後・・・・・・");
                        break;
                    case 43:
                        Bukkit.broadcastMessage("くも「これがこうでこうなって、だからこうやって投げれるんだよ」");
                        break;
                    case 44:
                        Bukkit.broadcastMessage("彼女ちゃん「うんうん」");
                        break;
                    case 45:
                        Bukkit.broadcastMessage("（長いなぁ…。）");
                        break;
                    case 46:
                        Bukkit.broadcastMessage("くも「違うよ、そうじゃない！僕が二人分一人で投げるから見てて」");
                        break;
                    case 47:
                        Bukkit.broadcastMessage("彼女ちゃん「え！？」");
                        break;
                    case 48:
                        Bukkit.broadcastMessage("くも「大丈夫！お金は僕が奢ったし、問題ないよね」");
                        break;
                    case 49:
                        Bukkit.broadcastMessage("-----------選択肢---------");
                        Bukkit.broadcastMessage("1、逃げる");
                        Bukkit.broadcastMessage("2、見てる");
                        Collection<? extends Player> onlinePlayers = Bukkit.getOnlinePlayers();
                        map.clear();
                        for (Player onlinePlayer : onlinePlayers) {
                            Location location = onlinePlayer.getLocation();
                            Location location2 = onlinePlayer.getLocation();
                            Team team = onlinePlayer.getScoreboard().getEntryTeam(onlinePlayer.getName());
                            Team team2 = onlinePlayer.getScoreboard().getEntryTeam(onlinePlayer.getName());
                            Team team3 = onlinePlayer.getScoreboard().getEntryTeam(onlinePlayer.getName());
                            if (team != null) {
                                if (!map.containsKey(team)&&haiti==0) {
                                    haiti++;
                                    @NotNull ArmorStand entity = location.getWorld().spawn(location, ArmorStand.class);
                                    entity.setGravity(false);
                                    entity.setSmall(true);
                                    entity.setArms(true);
                                    entity.addScoreboardTag("1");
                                    entity.setCustomNameVisible(true);
                                    entity.setCustomName("選択肢1");
                                    map.put(team, new Agent(entity));
                                   
                                    Agent agent = map.get(team);
                                    Location loc = agent.armorStand.getLocation();
                                    moveFrontLocation(loc, 90);
                                    loc.setY(loc.getY() + 2);
                                    adjustPosition(location);
                                    agent.armorStand.teleport(loc);
                                    //
                                    @NotNull ArmorStand entity2 = location2.getWorld().spawn(location2, ArmorStand.class);
                                    entity2.setGravity(false);
                                    entity2.setSmall(true);
                                    entity2.setArms(true);
                                    entity2.addScoreboardTag("2");
                                    entity2.setCustomNameVisible(true);
                                    entity2.setCustomName("選択肢2");
                                    map2.put(team2, new Agent(entity2));
                                  
                                    Agent agent2 = map2.get(team);
                                    Location loc2 = agent2.armorStand2.getLocation();
                                    moveFrontLocation(loc2, 90);
                                    loc2.setY(loc2.getY() + 1);
                                    loc2.setX(loc2.getX() - 1);
                                    adjustPosition(location2);
                                    agent2.armorStand2.teleport(loc2);
                                    //
                                }
                            } else {
                                player.sendMessage("チームが存在しません");
                            }
                        }
                        number = 53;
                        set = -99;
                        break;
                }
            } else if (26 <= number && number <= 53 && set == 2) {
                switch (number) {
                    case 26:
                        haiti=0;
                        for (Agent agent : map.values()){
                            agent.armorStand.remove();

                        }
                        for (Agent agent2 : map2.values()){
                            agent2.armorStand2.remove();

                        }
                        Bukkit.broadcastMessage("彼女ちゃん「カラオケがいい」");
                        break;
                    case 27:
                        Bukkit.broadcastMessage("くも「わかった」");
                        break;
                    case 28:
                        Bukkit.broadcastMessage("こうして私はくもさんに連れられ、カラオケへと来ました。");
                        break;
                    case 29:
                        Bukkit.broadcastMessage("くも「飲み物取ってきてあげるね」");
                        break;
                    case 30:
                        Bukkit.broadcastMessage("彼女ちゃん「ありがとう」");
                        break;
                    case 31:
                        Bukkit.broadcastMessage("（意外と優しいのかも？）");
                        break;
                    case 32:
                        Bukkit.broadcastMessage("くも「取ってきたよー」");
                        break;
                    case 33:
                        Bukkit.broadcastMessage("彼女ちゃん「ありがとう」");
                        break;
                    case 34:
                        Bukkit.broadcastMessage("彼女ちゃん「あれ？私オレンジジュースって言ったんだけど」");
                        break;
                    case 35:
                        Bukkit.broadcastMessage("くも「あ、コーラのほうが美味しいからコーラにしたよ」");
                        break;
                    case 36:
                        Bukkit.broadcastMessage("彼女ちゃん「え…？」");
                        break;
                    case 37:
                        Bukkit.broadcastMessage("くも「それよりほら、僕歌って良い？」");
                        break;
                    case 38:
                        Bukkit.broadcastMessage("彼女ちゃん「いいけど…」");
                        break;
                    case 39:
                        Bukkit.broadcastMessage("くも「二曲歌ったら一曲歌わせてあげるね」");
                        break;
                    case 40:
                        Bukkit.broadcastMessage("彼女ちゃん「え？？？」");
                        break;
                    case 41:
                        Bukkit.broadcastMessage("くも「あ、ポテト頼みたい」");
                        break;
                    case 42:
                        Bukkit.broadcastMessage("彼女ちゃん「ちょっと待って…？」");
                        break;
                    case 43:
                        Bukkit.broadcastMessage("くも「ん？なにか問題でも？」");
                        break;
                    case 44:
                        Bukkit.broadcastMessage("彼女ちゃん「私も歌いたいんだけど」");
                        break;
                    case 45:
                        Bukkit.broadcastMessage("くも「いや、歌えるじゃん」");
                        break;
                    case 46:
                        Bukkit.broadcastMessage("彼女ちゃん「でも二曲に一曲って？」");
                        break;
                    case 47:
                        Bukkit.broadcastMessage("くも「いや、俺が金払うし」");
                        break;
                    case 48:
                        Bukkit.broadcastMessage("くも「よくね？」");
                        break;
                    case 49:
                        Bukkit.broadcastMessage("彼女ちゃん「ごめん私帰るね」");
                        break;
                    case 50:
                        Bukkit.broadcastMessage("くも「え。ちょっと待って」");
                        break;
                    case 51:
                        Bukkit.broadcastMessage("それ以来、あの人とは連絡を取っていない");
                        break;
                    case 52:
                        Bukkit.broadcastMessage("今では素敵な彼氏が私にはいる。");
                        break;
                    case 53:
                        Bukkit.broadcastMessage("あんな人離れて正解でした。");
                        break;
                    case 54:
                        Bukkit.broadcastMessage("end5へ「これが幸せ」");
                        player.sendTitle(ChatColor.DARK_RED + "これが幸せ", "", 10, 40, 10);
                        number = 0;
                        set = 0;
                        break;
                }
            } else if (55 <= number && number <= 60 && set == 1) {
                switch (number) {
                    case 55:
                        haiti=0;
                        for (Agent agent : map.values()){
                            agent.armorStand.remove();

                        }
                        for (Agent agent2 : map2.values()){
                            agent2.armorStand2.remove();

                        }
                        Bukkit.broadcastMessage("彼女ちゃん「用事思い出した…！ごめん！先に帰るね」");
                        break;
                    case 56:
                        Bukkit.broadcastMessage("くも「え！？」");
                        break;
                    case 57:
                        Bukkit.broadcastMessage("くも「待ってよ！」");
                        break;
                    case 58:
                        Bukkit.broadcastMessage("彼女ちゃん「じゃあね」");
                        break;
                    case 59:
                        Bukkit.broadcastMessage("これ以降、私がこの人と連絡を取ることはなかった。");
                        break;
                    case 60:
                        Bukkit.broadcastMessage("end1「似合う人が見つかると良いね」");
                        number = 0;
                        set = 0;
                        break;
                }
            } else if (55 <= number && number <= 66 && set == 2) {
                switch (number) {
                    case 55:
                        haiti=0;
                        for (Agent agent : map.values()){
                            agent.armorStand.remove();

                        }
                        for (Agent agent2 : map2.values()){
                            agent2.armorStand2.remove();

                        }
                        Bukkit.broadcastMessage("彼女ちゃん「うん。わかった」");
                        break;
                    case 56:
                        Bukkit.broadcastMessage("・・・・・・・・2時間後・・・・・・・・");
                        break;
                    case 57:
                        Bukkit.broadcastMessage("くも「スコア200かぁ」");
                        break;
                    case 58:
                        Bukkit.broadcastMessage("くも「微妙」");
                        break;
                    case 59:
                        Bukkit.broadcastMessage("彼女ちゃん「そっかぁ。残念」");
                        break;
                    case 60:
                        Bukkit.broadcastMessage("くも「お腹空いたね。ご飯食べよ」");
                        break;
                    case 61:
                        Bukkit.broadcastMessage("彼女ちゃん「確かに、もうこんな時間だ。わかった」");
                        break;
                    case 62:
                        Bukkit.broadcastMessage("（夜景が綺麗なレストランとか予約してくれてるのかな？？）");
                        break;
                    case 63:
                        Bukkit.broadcastMessage("くも「ほら、ついたよ、夜景が綺麗なサイゼリヤ」");
                        break;
                    case 64:
                        Bukkit.broadcastMessage("彼女ちゃん「サイゼリヤ？？？？？？？？？」");
                        break;
                    case 65:
                        Bukkit.broadcastMessage("くも「うん。だって安くて美味しいし」");
                        break;
                    case 66:
                        Bukkit.broadcastMessage("-------------選択肢---------");
                        Bukkit.broadcastMessage("1、逃げる");
                        Bukkit.broadcastMessage("2、一緒に食べる");
                        Collection<? extends Player> onlinePlayers = Bukkit.getOnlinePlayers();
                        map.clear();
                        for (Player onlinePlayer : onlinePlayers) {
                            Location location = onlinePlayer.getLocation();
                            Location location2 = onlinePlayer.getLocation();
                            Location location3 = onlinePlayer.getLocation();
                            Team team = onlinePlayer.getScoreboard().getEntryTeam(onlinePlayer.getName());
                            Team team2 = onlinePlayer.getScoreboard().getEntryTeam(onlinePlayer.getName());
                            Team team3 = onlinePlayer.getScoreboard().getEntryTeam(onlinePlayer.getName());
                            if (team != null) {
                                if (!map.containsKey(team)&&haiti==0) {
                                    haiti++;
                                    @NotNull ArmorStand entity = location.getWorld().spawn(location, ArmorStand.class);
                                    entity.setGravity(false);
                                    entity.setSmall(true);
                                    entity.setArms(true);
                                    entity.addScoreboardTag("1");
                                    entity.setCustomNameVisible(true);
                                    entity.setCustomName("選択肢1");
                                    map.put(team, new Agent(entity));
                                   
                                    Agent agent = map.get(team);
                                    Location loc = agent.armorStand.getLocation();
                                    moveFrontLocation(loc, 90);
                                    loc.setY(loc.getY() + 2);
                                    adjustPosition(location);
                                    agent.armorStand.teleport(loc);
                                    //
                                    @NotNull ArmorStand entity2 = location2.getWorld().spawn(location2, ArmorStand.class);
                                    entity2.setGravity(false);
                                    entity2.setSmall(true);
                                    entity2.setArms(true);
                                    entity2.addScoreboardTag("2");
                                    entity2.setCustomNameVisible(true);
                                    entity2.setCustomName("選択肢2");
                                    map2.put(team2, new Agent(entity2));
                                  
                                    Agent agent2 = map2.get(team);
                                    Location loc2 = agent2.armorStand2.getLocation();
                                    moveFrontLocation(loc2, 90);
                                    loc2.setY(loc2.getY() + 1);
                                    loc2.setX(loc2.getX() - 1);
                                    adjustPosition(location2);
                                    agent2.armorStand2.teleport(loc2);

                                    //
                                }
                            } else {
                                player.sendMessage("チームが存在しません");
                            }
                        }
                        set = -99;
                        number++;
                        break;
                }
            } else if (68 <= number && number <= 73 && set == 1) {
                switch (number) {
                    case 68:
                        haiti=0;
                        for (Agent agent : map.values()){
                            agent.armorStand.remove();

                        }
                        for (Agent agent2 : map2.values()){
                            agent2.armorStand2.remove();

                        }
                        Bukkit.broadcastMessage("彼女ちゃん「用事思い出した…！ごめん！先に帰るね」");
                        break;
                    case 69:
                        Bukkit.broadcastMessage("くも「え！？」");
                        break;
                    case 70:
                        Bukkit.broadcastMessage("くも「待ってよ！」");
                        break;
                    case 71:
                        Bukkit.broadcastMessage("彼女ちゃん「じゃあね」");
                        break;
                    case 72:
                        Bukkit.broadcastMessage("これ以降、私がこの人と連絡を取ることはなかった。");
                        break;
                    case 73:
                        Bukkit.broadcastMessage("end1「似合う人が見つかると良いね」");
                        number = 0;
                        set = 0;
                        break;
                }
            } else if (68 <= number && number <= 85 && set == 2) {
                switch (number) {
                    case 68:
                        haiti=0;
                        for (Agent agent : map.values()){
                            agent.armorStand.remove();

                        }
                        for (Agent agent2 : map2.values()){
                            agent2.armorStand2.remove();

                        }
                        Bukkit.broadcastMessage("・・・・・・30分後・・・・・・・");
                        break;
                    case 69:
                        Bukkit.broadcastMessage("彼女ちゃん「美味しいね…」");
                        break;
                    case 70:
                        Bukkit.broadcastMessage("くも「うん。俺のピザ一枚上げるよ」");
                        break;
                    case 71:
                        Bukkit.broadcastMessage("彼女ちゃん「え、でも私お腹いっぱいなんだけど」");
                        break;
                    case 72:
                        Bukkit.broadcastMessage("くも「いいから食べて食べて」");
                        break;
                    case 73:
                        Bukkit.broadcastMessage("彼女ちゃん「ごめん。本当にお腹いっぱいなの」");
                        break;
                    case 74:
                        Bukkit.broadcastMessage("くも「そっかぁ」");
                        break;
                    case 75:
                        Bukkit.broadcastMessage("・・・・・・10分後・・・・・・");
                        break;
                    case 76:
                        Bukkit.broadcastMessage("くも「美味しかったね」");
                        break;
                    case 77:
                        Bukkit.broadcastMessage("彼女ちゃん「うん…」");
                        break;
                    case 78:
                        Bukkit.broadcastMessage("くも「僕がお金出すよ。待ってて」");
                        break;
                    case 79:
                        Bukkit.broadcastMessage("・・・・・・・5分後・・・・・・・");
                        break;
                    case 80:
                        Bukkit.broadcastMessage("くも「そういや外寒いね…ちょっと歩こうか」");
                        break;
                    case 81:
                        Bukkit.broadcastMessage("彼女ちゃん「うん」");
                        break;
                    case 82:
                        Bukkit.broadcastMessage("くも「おれ、今日一日彼女ちゃんと一緒にいて、すごく楽しかったんだ」");
                        break;
                    case 83:
                        Bukkit.broadcastMessage("彼女ちゃん「うん」");
                        break;
                    case 84:
                        Bukkit.broadcastMessage("くも「だから僕と付き合ってほしいんだ」");
                        break;
                    case 85:
                        Bukkit.broadcastMessage("----------選択肢------------");
                        Bukkit.broadcastMessage("1、付き合う。");
                        Bukkit.broadcastMessage("2、断る");
                        Bukkit.broadcastMessage("3、お金は出してくれたのでお金だけ定期的に出してくれるようにいい感じに扱う");
                        Collection<? extends Player> onlinePlayers = Bukkit.getOnlinePlayers();
                        map.clear();
                        for (Player onlinePlayer : onlinePlayers) {
                            Location location = onlinePlayer.getLocation();
                            Location location2 = onlinePlayer.getLocation();
                            Location location3 = onlinePlayer.getLocation();
                            Team team = onlinePlayer.getScoreboard().getEntryTeam(onlinePlayer.getName());
                            Team team2 = onlinePlayer.getScoreboard().getEntryTeam(onlinePlayer.getName());
                            Team team3 = onlinePlayer.getScoreboard().getEntryTeam(onlinePlayer.getName());
                            if (team != null) {
                                if (!map.containsKey(team)&&haiti==0) {
                                    haiti++;
                                    @NotNull ArmorStand entity = location.getWorld().spawn(location, ArmorStand.class);
                                    entity.setGravity(false);
                                    entity.setSmall(true);
                                    entity.setArms(true);
                                    entity.addScoreboardTag("1");
                                    entity.setCustomNameVisible(true);
                                    entity.setCustomName("選択肢1");
                                    map.put(team, new Agent(entity));
                                   
                                    Agent agent = map.get(team);
                                    Location loc = agent.armorStand.getLocation();
                                    moveFrontLocation(loc, 90);
                                    loc.setY(loc.getY() + 2);
                                    adjustPosition(location);
                                    agent.armorStand.teleport(loc);
                                    //
                                    @NotNull ArmorStand entity2 = location2.getWorld().spawn(location2, ArmorStand.class);
                                    entity2.setGravity(false);
                                    entity2.setSmall(true);
                                    entity2.setArms(true);
                                    entity2.addScoreboardTag("2");
                                    entity2.setCustomNameVisible(true);
                                    entity2.setCustomName("選択肢2");
                                    map2.put(team2, new Agent(entity2));
                                  
                                    Agent agent2 = map2.get(team);
                                    Location loc2 = agent2.armorStand2.getLocation();
                                    moveFrontLocation(loc2, 90);
                                    loc2.setY(loc2.getY() + 1);
                                    loc2.setX(loc2.getX() - 1);
                                    adjustPosition(location2);
                                    agent2.armorStand2.teleport(loc2);
                                    //
                                    @NotNull ArmorStand entity3 = location3.getWorld().spawn(location3, ArmorStand.class);
                                    entity3.setGravity(false);
                                    entity3.setSmall(true);
                                    entity3.setArms(true);
                                    entity3.addScoreboardTag("3");
                                    entity3.setCustomNameVisible(true);
                                    entity3.setCustomName("選択肢3");
                                    map3.put(team3, new Agent(entity3));
                                    
                                    Agent agent3 = map3.get(team);
                                    Location loc3 = agent3.armorStand3.getLocation();
                                    moveFrontLocation(loc3, 90);
                                    loc3.setY(loc3.getY() + 1);
                                    loc3.setX(loc3.getX() + 1);
                                    adjustPosition(location3);
                                    agent3.armorStand3.teleport(loc3);
                                    number++;
                                }
                            } else {
                                player.sendMessage("チームが存在しません");
                            }
                        }
                        set = -99;
                        break;
                }
            } else if (87 <= number && number <= 200 && set == 1) {
                switch (number) {
                    case 87:
                        haiti=0;
                        for (Agent agent : map.values()){
                            agent.armorStand.remove();

                        }
                        for (Agent agent2 : map2.values()){
                            agent2.armorStand2.remove();

                        }
                        for (Agent agent3 : map3.values()){
                            agent3.armorStand3.remove();

                        }
                        Bukkit.broadcastMessage("彼女ちゃん「私も楽しかったよ。お金とかたくさん出してくれたし」");
                        break;
                    case 88:
                        Bukkit.broadcastMessage("彼女ちゃん「ボウリングも色々教えてくれたし」");
                        break;
                    case 89:
                        Bukkit.broadcastMessage("彼女ちゃん「私なんかで良ければ…」");
                        break;
                    case 90:
                        Bukkit.broadcastMessage("・・・・・・・30年後・・・・・・・");
                        break;
                    case 91:
                        Bukkit.broadcastMessage("私はくもくんと結婚した。");
                        break;
                    case 92:
                        Bukkit.broadcastMessage("くもくんはわがままで迷惑かけるし、意味分かんないこと言うけど");
                        break;
                    case 93:
                        Bukkit.broadcastMessage("私は今とても幸せだ。あ、くもくんが呼んでる。飲み物買ってこなきゃ");
                        break;
                    case 94:
                        Bukkit.broadcastMessage("end2へ「一生奴隷」");
                        number = 0;
                        set = 0;
                        break;
                }
            } else if (87 <= number && number <= 200 && set == 2) {
                switch (number) {
                    case 87:
                        haiti=0;
                        for (Agent agent : map.values()){
                            agent.armorStand.remove();

                        }
                        for (Agent agent2 : map2.values()){
                            agent2.armorStand2.remove();

                        }
                        for (Agent agent3 : map3.values()){
                            agent3.armorStand3.remove();

                        }
                        Bukkit.broadcastMessage("彼女ちゃん「ごめん。私自分勝手な人無理なの」");
                        break;
                    case 88:
                        Bukkit.broadcastMessage("くも「え、でも楽しそうだったし…」");
                        break;
                    case 89:
                        Bukkit.broadcastMessage("彼女ちゃん「それは傷つけないために…」");
                        break;
                    case 90:
                        Bukkit.broadcastMessage("彼女ちゃん「ごめんね」");
                        break;
                    case 91:
                        Bukkit.broadcastMessage("くも「僕を騙してたんだね」");
                        break;
                    case 92:
                        Bukkit.broadcastMessage("彼女ちゃん「そんなことないよ！？」");
                        break;
                    case 93:
                        Bukkit.broadcastMessage("くも「ナイフどこやったかな…」");
                        break;
                    case 94:
                        Bukkit.broadcastMessage("彼女ちゃん「くもくん落ち着いて！？」");
                        break;
                    case 95:
                        Bukkit.broadcastMessage("ｸﾞｻｯ");
                        break;
                    case 96:
                        Bukkit.broadcastMessage("今日未明一緒にデートをしていた女性が刃物で刺される事件がありました。");
                        break;
                    case 97:
                        Bukkit.broadcastMessage("犯人は依然逃亡しており・・・・");
                        break;
                    case 98:
                        Bukkit.broadcastMessage("end3へ「人って怖いね」");
                        number = 0;
                        set = 0;
                        break;
                }
            } else if (87 <= number && number <= 200 && set == 3) {
                switch (number) {
                    case 87:
                        haiti=0;
                        for (Agent agent : map.values()){
                            agent.armorStand.remove();

                        }
                        for (Agent agent2 : map2.values()){
                            agent2.armorStand2.remove();

                        }
                        for (Agent agent3 : map3.values()){
                            agent3.armorStand3.remove();

                        }
                        Bukkit.broadcastMessage("彼女ちゃん「いいよ」");
                        break;
                    case 88:
                        Bukkit.broadcastMessage("くも「やったー」");
                        break;
                    case 89:
                        Bukkit.broadcastMessage("それから私はくもくんを利用しようとしたが、失敗して今では永遠にストーカーされている");
                        break;
                    case 90:
                        Bukkit.broadcastMessage("end4へ「一生ストーカー」");
                        number = 0;
                        set = 0;
                        break;
                }
            }
        }
    }

    public class Agent {
        public ArmorStand armorStand;
        public ArmorStand armorStand2;
        public ArmorStand armorStand3;
        public int time = 0;

        public Agent(ArmorStand entity) {
            armorStand = entity;
            armorStand2 = entity;
            armorStand3 = entity;

        }
    }

    private Location moveFrontLocation(Location loc, double dir) {
        ;
        dir += loc.getYaw();
        double x = Math.cos(Math.toRadians(dir));
        double z = Math.sin(Math.toRadians(dir));
        loc.setX(loc.getX() + x);
        loc.setZ(loc.getZ() + z);
        return loc;
    }
    @NotNull
    private EulerAngle makeAngle(double x, double y, double z) {
        return new EulerAngle(Math.toRadians(x), Math.toRadians(y), Math.toRadians(z));
    }
    private void adjustPosition(Location loc) {
        float a = loc.getYaw();
        a = (float) Math.floor(a / 90) * 90;
        loc.setYaw(a);
    }
    int sentaku;
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equals("KumoSimulation")) {
            if (sender instanceof Player) {
                if (args.length == 0) {
                    sender.sendMessage("引数を指定してください。");
                } else {
                    String chat = args[0];
                    sentaku = Integer.parseInt(chat);
                    number = sentaku;
                    set=0;
                    //System.out.println(set);
                    //System.out.println(number);
                    sender.sendMessage("選択肢をリセットしました。");

                }
            }
        }
        return super.onCommand(sender, command, label, args);
    }
}